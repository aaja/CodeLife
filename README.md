# demoCode

## Overview

The so-called sorting algorithm is to re-sort one or more sets of data according to a predetermined pattern through a specific algorithm factor. This new sequence follows certain rules and reflects certain laws. Therefore, the processed data is convenient for screening and calculation, which greatly improves the calculation efficiency. For sorting, we first require it to have a certain degree of stability, that is, when two identical elements appear in a sequence at the same time, after a certain sorting algorithm, the relative positions of the two before and after sorting will not change. In other words, even if there are two identical elements, they are different in the ordering process, and confusion is not allowed. 

## sort

Sorting is an important operation in computer programming. Its function is to rearrange an arbitrary sequence of data elements (or records) into an ordered sequence of keywords.
Sorting is to sort the elements in the set together in a certain order. Generally speaking, there are two sorts of ascending order and descending order. There are 8 basic sorts in the algorithm:
- (1) Bubble sorting;
- (2) Selection order;
- (3) Insertion sort;
- (4) Hill sorting;
- (5) Merge and sort;
- (6)Quick sort;
- (7) Cardinal number sorting;
- (8) Heap sorting;
- (9) Count and sort;
- (10) Bucket sorting.

## standard

Stability is a particularly important evaluation criterion. A stable algorithm will not change the relative order of the positions of the elements during the sorting process. On the contrary, an unstable sorting algorithm will often change this order, which we do not want to see. When we use the sorting algorithm or selecting the sorting algorithm, we hope that the order will not change and be more stable. Therefore, the stability of the sorting algorithm is a particularly important parameter measurement index basis. Just like space complexity and time complexity, sometimes it is even more important than time complexity and space complexity. Therefore, it is often possible to evaluate the quality of a sorting algorithm from the following aspects:
- (1) Time complexity: the measurement of time spent in the process from the initial state of the sequence to the transformation and shifting of the sorting algorithm to the final state of the sorted result.
- (2) Space complexity: It is the space overhead spent from the initial state of the sequence through the process of sorting shift transformation to the final state.
- (3) Usage scenarios: There are many sorting algorithms, and different kinds of sorting algorithms are suitable for different kinds of scenarios. Sometimes it is necessary to save space and not so much time requirement. On the contrary, sometimes it is hoped to consider more time and space requirements. Not so high, in short, you generally have to make a decision from one aspect.
- (4) Stability: Stability is a problem that must be considered regardless of time and space, and it is often a very important factor affecting choice. 