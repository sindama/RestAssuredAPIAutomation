Feature: Validating Place API's

@AddPlace
Scenario Outline: Verify if place is being successfully added using AddPlcaeAPI
Given Add place payload "<name>" "<language>" "<address>"
When user calls "addPlaceAPI" with "post" http request 
Then the API call is success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify place_ID matche to "<name>" using "getPlaceAPI"
Examples:
|name| language|address|
|anjana|English|India|
#|supriya|English|India|
@DeletePlace
Scenario: Verify if Delete functionality is working 
     Given DeletePlace Payload
     When user calls "deletePlaceAPI" with "post" http request
     Then the API call is success with status code 200
     And "status" in response body is "OK"