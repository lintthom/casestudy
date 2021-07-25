Feature: To Validate New User registration for a Elearning App



Scenario Outline: New user registration

Given user is in registration page
And user enters firstname "<FirstName>"
And user enters lastname "<LastName>"
And user enters e-mail id "<EmailId>"
And user enters username "<UserName>"
And user enters password "<Password>"
And user confirms the password "<ConfirmPwd>"
When user clicks on register button
Then user sees the confirmation message "<Name>"
And user navigates to HomePage
Then user click on compose
And user enters recipient email "<RecipientEmail>"
And user enters subject "<Subject>"
And user enters enters message
When user clicks on send message button
Then user sees success message "<SuccessMessage>"
When user tries to logout 
Then user is logged out

Examples:
|FirstName|LastName|EmailId|UserName|Password|ConfirmPwd|Name|RecipientEmail|Subject|SuccessMessage|
|Rahul|Nambiar|nambiar@hotmail.com|rnambiar|nambiar123|nambiar123|Rahul Nambiar|rvasudevan|Test Email1|The message has been sent to |
|Seethu|Santhosh|ss@hotmail.com|seesanthosh|seethu123|seethu123|Seethu Santhosh|nishamenon3|Test Email2|The message has been sent to |
|Eyan|Bhaskar|eb@gmail.com|eyanbhaskar|eyan123|eyan123|Eyan Bhaskar|rnambiar|Test Email2|The message has been sent to |


