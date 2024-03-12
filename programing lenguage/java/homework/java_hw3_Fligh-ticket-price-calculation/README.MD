# Flight ticket price calculation

Create a program in Java that calculates flight ticket prices according to distance and conditions. Get Distance (KM), age and trip type (One Way, Round Trip) from the user. Get the price per distance as 0.10 TL / km. First, calculate the total price of the flight and then apply the following discounts to the customer according to the conditions;

The values received from the user must be valid (distance and age values must be positive numbers, trip type must be 1 or 2). Otherwise, the user will be told "You have entered incorrect data!" A warning should be given.
If the person is under 12 years old, a 50% discount is applied on the ticket price.
If the person is between the ages of 12-24, a 10% discount is applied to the ticket price.
If the person is over 65 years old, a 30% discount is applied on the ticket price.
If the person has selected "Trip Type" round trip, a 20% discount is applied on the ticket price.
Clue
Normal Amount = Distance * 0.10 = 1500 * 0.10 = 150 TL
Age Discount = Normal Amount * Age Discount Rate = 150 * 0.10 = 15 TL
Discounted Amount = Normal Amount – Age Discount = 150 – 15 = 135 TL
Round Trip Ticket Discount = Discounted Amount * 0.20 = 135 * 0.20 = 27 TL
Total Amount = (135-27)* 2 = 216 TL
Scenarios
Scenario 1
Enter the distance in km: 1500
Enter your age: 20
Enter the trip type (1 => One Way, 2 => Round Trip): 2

Total Amount = 216 TL
Scenario 2
Enter the distance in km: -500
Enter your age: 1
Enter the trip type (1 => One Way, 2 => Round Trip): 77

You Entered Incorrect Data!
Scenario 3
Enter the distance in km: 200
Enter your age: 35
Enter the trip type (1 => One Way, 2 => Round Trip): 1

Total Amount = 20.0 TL

Check [here](https://academy.patika.dev/tr/courses/java101/odev-ucak-bileti) for more imformation