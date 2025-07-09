## Assumptions and comments

### Inputs, validation and error handling

Inputs are validated and exceptions are thrown when invalid.  
Valid inputs are:
- Team name is not empty
- Home team and away team are not the same
- Score is not negative

I was considering what would be the best approach to handling an attempt to create 
a match with teams that are already in the scoreboard. I decided to 
throw an invalid input exception instead of silently returning the already
existing match, as I find it to be more meaningful response.

