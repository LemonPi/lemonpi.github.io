---
layout: single
title: Trap Aware MPC
permalink: /projects/tampc/index.html
group: projects
css: syntax
---

## Links
- [RA-L preprint (arxiv)](https://arxiv.org/abs/2010.12516)
- [video](https://www.youtube.com/watch?v=XB-INROSWBE&ab_channel=UniversityofMichiganARMLab)
- [repository](https://github.com/UM-ARM-Lab/tampc)

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

