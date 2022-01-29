---
layout: single
title: Trap Aware MPC
permalink: /projects/tampc/index.html
group: projects
css: syntax
---

## Links
- [RA-L preprint (arxiv)](https://arxiv.org/abs/2010.12516)
- [repository](https://github.com/UM-ARM-Lab/tampc)

<iframe width="560" height="315" src="https://www.youtube.com/embed/XB-INROSWBE" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

## Abstract

We propose an approach to online model adaptation and control in the
challenging case of hybrid and discontinuous dynamics where actions may
lead to difficult-to-escape "trap" states, under a given controller. We
first learn dynamics for a system without traps from a randomly
collected training set
(since we do not know what traps will be encountered online). These
"nominal" dynamics allow us to perform tasks 
in scenarios where the dynamics matches the training data,
but when unexpected traps arise in execution, we must find a way to
adapt our dynamics and control strategy and continue attempting the
task. Our approach, Trap-Aware Model Predictive Control (TAMPC), is a
two-level hierarchical control algorithm that reasons about traps and
non-nominal dynamics to decide between goal-seeking and recovery
policies.
An important requirement of our method is the ability to recognize
nominal dynamics even when we encounter data that is
out-of-distribution w.r.t the training data. We achieve this by
learning a representation for dynamics that exploits invariance in the
nominal environment, thus allowing better generalization. We evaluate
our method on simulated planar pushing and peg-in-hole as well as real
robot peg-in-hole problems against adaptive control, reinforcement
learning, trap-handling baselines, where traps arise due to unexpected
obstacles that we only observe through contact. Our results show that
our method outperforms the baselines on difficult tasks, and is
comparable to prior trap-handling methods on easier tasks.

>> Problem is difficult because the robot has no visual sensing and has never observed traps induced by walls during training

## Highlights
- formally defines traps for a given controller
- high level TAMPC can be used with many lower level MPC methods
- introduces latent dynamics architecture that exploits training data invariants to be more robust to out of distribution test data

<div class="frames">
<img width="100%" src="/projects/tampc/learning6.png">
<p>Learning curves on validation (left) and out of distribution (right) data with mean across 10 runs in solid 
and 1 standard deviation shaded. Lower relative MSE is better.
</p>
</div>

- capable of escaping traps that requires many control steps to escape (deep), or are close to the goal

<div class="frames">
<img width="100%" src="/projects/tampc/init.png">
<p>Initial condition of simulated environments and typical traps for each task. The planar pushing (left) traps
require multiple control steps pushing in the same direction while the peg-in-hole traps are placed close to the goal.
</p>
</div>

- capable of completing tasks that adaptive control and reinforcement learning baselines find impossible while
outperforming trap-handling baselines on planar pushing tasks
  
<div class="frames">
<img width="100%" src="/projects/tampc/tab.png">
<p>Results table over simulated and real tasks, with success defined as reaching sufficiently close to the goal
within 500 control steps.
</p>
</div>
