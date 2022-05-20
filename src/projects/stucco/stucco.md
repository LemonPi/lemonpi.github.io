---
layout: single 
title: Soft Tracking Using Contacts for Cluttered Objects (STUCCO)
permalink: /projects/stucco/index.html 
group: projects 
---


## Links

- [IEEEXplore (RA-L 2022)](https://ieeexplore.ieee.org/document/9696372)
- [arxiv](https://arxiv.org/abs/2201.10434)
- [repository](https://github.com/UM-ARM-Lab/stucco)
  

<aside class='notice'>
<iframe width="100%" height="500px" src="https://www.youtube.com/embed/dsXPH-IL590" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</aside>

## Abstract


Retrieving an object from cluttered spaces such as cupboards, refrigerators, or bins requires tracking objects with
limited or no visual sensing. In these scenarios, contact feedback is necessary to estimate the pose of the objects, yet
the objects are movable while their shapes and number may be unknown, making the association of contacts with objects
extremely difficult. While previous work has focused on multi-target tracking, the assumptions therein prohibit using
prior methods given only the contact-sensing modality. Instead, this paper proposes the method Soft Tracking Using
Contacts for Cluttered Objects (STUCCO)
that tracks the belief over contact point locations and implicit object associations using a particle filter. This
method allows ambiguous object associations of past contacts to be revised as new information becomes available. We
apply STUCCO to the Blind Object Retrieval problem, where a target object of known shape but unknown pose must be
retrieved from clutter. Our results suggest that our method outperforms baselines in four simulation environments, and
on a real robot, where contact sensing is noisy. In simulation, we achieve grasp success of at least 65% on all
environments while no baselines achieve over 5%.

>> Problem is difficult because the robot has no visual sensing while the objects are movable

<br/>

<div style="width:100%">
<img width="100%" src="/projects/stucco/stucco_method.png">
</div>
 
## Highlights
- first paper to track multiple objects using only contact feedback
- resolves ambiguity in data association far in the past with new information
- outperforms baselines in tracking metrics of contact error and segmentation quality using the Fowlkes-Mallows index

<div>
<div style="flex-direction:row; width:100%">
<img width="49.5%" src="/projects/stucco/tracking_res_rev.png">
<img width="49.5%" src="/projects/stucco/tracking_res_rev_high_ambiguity.png">
</div>
<p>Higher FMI is better while lower contact error is better. Error bars indicate 20-80th percentile. Ours is in blue.</p>
</div>

- able to segment contacts points into objects and track the target object's pose sufficiently to grasp in simulated
and real environments
  
<aside class='notice'>
<img width="100%" src="/projects/stucco/bor-min.png">
<p>4 simulated environments with a floating gripper. Top shows the initial condition and the bottom shows near the end
of one of our runs. Robot state trail and best estimate for target pose are in blue, tracked contact points are crosses
with each color corresponding to a segmented object. Our method achieves at least 65% grasp success across all environments
while none of the baselines exceed 5%.</p>
</aside>

<br/>

<aside class='notice'>
<img width="100%" src="/projects/stucco/real_bubble_min.png">
<p>Real environment with (top) initial condition and (bot) successful tracking in one of our runs.
</p>
</aside>

## Bibtex
```text
@ARTICLE{9696372,
  author={Zhong, Sheng and Fazeli, Nima and Berenson, Dmitry},
  journal={IEEE Robotics and Automation Letters}, 
  title={Soft Tracking Using Contacts for Cluttered Objects to Perform Blind Object Retrieval}, 
  year={2022},
  volume={7},
  number={2},
  pages={3507-3514},
  doi={10.1109/LRA.2022.3146915}}
```
