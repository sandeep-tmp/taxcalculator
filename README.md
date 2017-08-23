This problem consists in writing a simple application that prints out the details of a receipt 
containing items purchased by a customer. The receipt should list the number of items, the name, the final price (including taxes) 
of each of the item purchased, plus two extra lines showing the total amount of the receipt and the total amount of taxes.

Taxes are calculated with a rate of 17.5%, rounding the tax result to the upper 0.05. Please note that medical products are exempt 
and an additional 1.25 fixed amount is added as an extra tax on CDs

What you need to provide
We expect you to provide a working solution to the problem, at least for the scenarios provided; 
it may just consist of hard coded data in a set of unit tests. Please note that input/output or persistency are NOT required. 
Concentrate your efforts on

•	Design
•	Simplicity
•	Testability/Test coverage
•	Extensibility

It’s absolutely fine if you execute this through junit tests, don’t focus on dynamic inputs, string parsing, etc.,

Examples

Input: 
1 book: 29.49 
1 music CD: 15.99 
1 chocolate snack: 0.75
Output: 
1 book: 34.69 
1 music CD: 20.04 
1 chocolate snack: 0.90 
Sales Taxes: 9.40 
Total: 55.63

Input: 
1 bottle of wine: 20.99 
1 box of tooth ache pills: 4.15 
1 box of pins: 11.25 
1 music CD: 14.99
Output: 
1 bottle of wine: 24.69 
1 box of headache pills: 4.15 
1 box of pins: 13.25 
1 music CD: 18.89 
Sales Taxes: 9.60 
Total: 60.98

Assumptions: 
1. 1.25 is added on Each CD
2. Round off to nearest 0.05 happens for all quantities combined together.
