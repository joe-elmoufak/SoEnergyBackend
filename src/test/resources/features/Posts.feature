Feature: Request for creating, retrieving and amending posts

#  Create a post successfully. Check Response code. Check Headers are correct
  @Post
  Scenario: Create a post request with the correct endpoint and verify I get a 20x response
    Given I execute a "successful" request when creating a new post
    Then I verify that the Post returns a "successful" status code
    And I verify that the "Server" header is returned with the expected value

  @Post
  Scenario: Try to create a post with a non existent endpoint and verify that I get a 40x response
    Given I execute a "bad_request" request when creating a new post
    Then I verify that the Post returns a "bad_request" status code

#  Verify part of the response of a get call (in this case it is an array). Cycle through array and make sure that there are no email addresses that are in an incorrect format
#  EG - email.email.com etc
  @Get
  Scenario: Retrieve an array of posts and check that email addresses are returned in a valid format
    Given I execute a request to retrieve a post
    Then I cycle through each post that is returned and verify the email addresses are in a valid format

  @Put
  Scenario: Make a change to a post by ID and verify the correct post ID was updated in the response
    Given I execute a request to change post id "1"
    Then I verify that it was id 1 that was changed in the response