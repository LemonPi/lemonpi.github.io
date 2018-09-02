---
layout: single
title: Kepler Communications Internship
permalink: /projects/kepler/index.html
group: projects
---

For 12 weeks during the summer of 2018
I worked at <a href="http://www.keplercommunications.com/">Kepler Communications</a>
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