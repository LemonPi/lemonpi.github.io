---
layout: single 
title: CHSEL - Producing Diverse Plausible Pose Estimates from Contact and Free Space Data
permalink: /projects/chsel/index.html 
group: projects 
---


## Links

- [repository](https://github.com/UM-ARM-Lab/chsel)
  

<!-- <aside class='notice'>
<iframe width="100%" height="500px" src="https://www.youtube.com/embed/dsXPH-IL590" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</aside> -->

<aside class='notice'>
<img width="100%" src="https://i.imgur.com/bxdpgpk.gif">
<img width="100%" src="https://i.imgur.com/gbBBQpB.gif">
<p>CHSEL applied to sparse contact data on the YCB drill (top) and dense camera data on a mug (bottom). Yellow points are observed free space points while blue points are observed surface points.</p>
</aside>

## Abstract

This paper proposes a novel method for estimating the set of plausible poses of a rigid object from a set of points with volumetric information, such as whether each point is in free space or on the surface of the object. In particular, we study how pose can be estimated
from force and tactile data arising from contact. 
Using data derived from contact is challenging because it is inherently less information-dense than visual data, and thus the pose estimation problem is severely under-constrained when there are few contacts. 
Rather than attempting to estimate the true pose of the object, which is not tractable without a large number of contacts, we seek to estimate a plausible set of poses which obey the constraints imposed by the sensor data. Existing methods struggle to estimate this set because they are either designed for single pose estimates or require informative priors to be effective. Our approach to this problem, Constrained pose Hypothesis Set Elimination (CHSEL), has three key attributes: 1) It considers volumetric information, which allows us to account for known free space; 2) It uses a novel differentiable volumetric cost function to take advantage of powerful gradient-based optimization tools; and 3) It uses methods from the Quality Diversity (QD) optimization literature to produce a diverse set of high-quality poses. To our knowledge, QD methods have not been used previously for pose registration. We also show how to update our plausible pose estimates online as more data is gathered by the robot. 
Our experiments suggest that CHSEL shows large performance improvements over several baseline methods for both simulated and real-world data. 


>> The core idea is to use negative information from free space to constrain pose estimates

<br/>

## Highlights
- input point cloud only requiring semantics level information (e.g. that it is in free space, or on the object surface)
- differentiable cost function to measure discrepency between a pose estimate and the semantic point cloud
- produces a set of plausible pose estimates instead of a single one
- first method to apply Quality Diversity (QD) optimization to pose estimation
- outperforms baselines in the Plausible Diversity metric against ground truth plausible sets of pose estimates

<img width="100%" src="/projects/chsel/chsel_real_pd.png">

Lower Plausible Diversity (see Equation 5 in the paper for its definition) is better. The figure above compares our method against baselines on real world data that combines vision and contact feedback.

<aside class='notice'>
<img width="100%" src="/projects/chsel/chsel_real_teaser.png">
<p>Set up of a real-world probing experiment where the goal is to estimate the pose of the drill. Data is collected from the partially occluded camera as well as the soft bubble gripper that rummages with a fixed policy.</p>
</aside>


## Bibtex
```text
@inproceedings{zhong2023chsel,
  title={CHSEL: Producing Diverse Plausible Pose Estimates from Contact and Free Space Data},
  author={Zhong, Sheng and Fazeli, Nima and Berenson, Dmitry},
  booktitle={Robotics science and systems},
  year={2023}
}
```
