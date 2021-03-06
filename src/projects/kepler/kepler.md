---
layout: single
title: Kepler Communications Internship
permalink: /projects/kepler/index.html
group: projects
css: syntax
---

For 12 weeks during the summer of 2018
I worked at [Kepler Communications](http://www.keplercommunications.com/)
as a software engineering intern.

I designed and implemented the mission control software backend
to replace a third party solution which was not scalable and had usability issues.

## Entities

- satellite - orbiting around Earth
- ground stations - giant antennas around Earth that physically transmit and receive
- operations computer (ops) - computer(s) managing operations that handles information to
    and from multiple ground stations
    
## Challenges

Kepler works with low earth orbit satellites that orbit around Earth very quickly.
Communication is only possible when they're visible to a ground station, usually
lasting around 10 minutes each with many hour gaps in between.
These opportunities are called **passes**.
        
The link quality increases as the altitude of the satellite relative to the ground
station increases, up to a maximum in the middle of the pass. Packets are frequently
lost, especially when the altitude is low.

## MCS Backend

The MCS backend is a software library and a collection of scripts. Its interface includes
calling the library functions, running the scripts, and querying/writing to a central
database.

It's responsible for communicating with the satellites and automating operations
through task scheduling.

## Features

- Scalable to many satellites and ops machines
- Flexible in choosing communication protocol on a per satellite basis
- Task scheduling and resumption across passes


>> Company specific details are omitted from the explanation of these features.

### Scalable

A major goal of the MCS is to simultaneously communicate with many satellites
to support future constellations of up to 200 satellites. 
Communication is only possible for one satellite per ground station because 
we need to point the antenna at the satellite, so the actual scalability requirement is 
only up to the number of ground stations.

Since it's quick to create and send packets, each ops machine is idle most of the time
waiting for response packets. The time waiting for a response to one routine can be spent
on executing another routine, potentially on another satellite. Conceptually, this follows
the asynchronous programming paradigm: long operations (coroutines) dependent on external
sources for their completion can `await` their completion while allowing other coroutines
to execute.

In python, this paradigm is offered by its `asyncio` module. Python was used because it's
the only language the rest of the software team all knew, and I only had 12 weeks to design
and implement everything. The prototyping and testing time is significantly shorter with python
than a compiled language. And since the performance is bottled by the network, 
the language choice will not significantly affect performance.


### Flexible

Another major goal of the MCS is to support communication with satellites of different generations. 
The onboard software for these will be different and may use different communication protocols.

This flexibility comes from the modular decomposition of the responsibilities of a communication
protocol down to these following **slots**
1. packets defining the structure of what gets transmitted and received
2. builder defining what packets to send for each intent
3. parser converting a sequence of bytes to a sequence of packets
4. handler implementing the logic of basic procedures for how to respond to packets 

A comms object bundling implementations for those slots 
is created at satellite definition time and attached to the satellite.
After definition, all operations on the satellite are communication method agnostic.


### Scheduling Tasks

Tasks provide the mechanism for operations to be carried out across passes.
Often a single pass may not be enough to complete a long operation 
(ex. downlink telemetry data) due to unreliable connections. 

Persistence is achieved through a database. 
An important point is to keep only one ultimate source of truth 
- whether it's in code or the database, usually the one with greater persistence.
This avoids having multiple definitions for a task and the subtle bugs that can arise from that.


>>> With unreliable asynchronous communication, it's important to always have
an appropriate timeout with each operation!


## Gains from Experience
- appreciation for the beauty of relational databases
- proficiency with SQL and MySQL
- asynchronous programming experience with `asyncio` in python
- proficiency with `pytest` 