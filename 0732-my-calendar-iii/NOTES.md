INTUITION:
Track the startTime and endTime in sorted order.
Eg - [start at 5, start at 10, end at 11, start at 13, end at 16, end at 21] ---> [5, 10, 11, 13, 16, 21] ---> timings are in sorted order.
​
When events are having duplicate start, increase start by 1 ---> meaning that this start time is actually start for more multiple events.
​
When events are having duplicate end, decrease end by 1 ---> meaning that this end time is actually end for more multiple events.
​
Now count how many events are having a start time in a row.
Eg - [2 events start at 5, 1 event starts at 10, 1 event ends at 11, 1 event ends at 15, 1 event starts at 16, 2 event ends at 18] ----> [2, 1, -1, -1, 1, -2] ---> start times in a row is 2 + 1 = 3