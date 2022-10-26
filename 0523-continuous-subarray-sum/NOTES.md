Keep running sum
In each step, store the remainder (sum%k) only.
Why remainder?
Lets take this example:   [11,  4, 1, 1],   k = 6
sum = 11 --> I got a remainder of 5.
sum = 15 --> Then I got remainder of 3.
sum = 16 --> Then I got remainder of 4.
sum = 17 --> Then I got remainder of 5 again --> This means we got sum as a multiple of k