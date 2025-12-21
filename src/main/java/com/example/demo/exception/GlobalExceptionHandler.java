
Code	Details
500
Undocumented
Error: response status is 500

Response body
Download
{
  "timestamp": "2025-12-21T07:54:20.333+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "path": "/api/tier-rules"
}
Response headers
 content-type: application/json 
 date: Sun,21 Dec 2025 07:54:20 GMT 
 server: nginx/1.29.4 
Responses
Code	Description	Links
200	
OK

Media type

*/*
Controls Accept header.
Example Value
Schema
{
  "id": 0,
  "fromTier": "string",
  "toTier": "string",
  "minSpend": 0,
  "minVisits": 0,
  "active": true
}
No links

GET
/api/tier-rules/lookup


GET
/api/tier-rules/active

customer-profile-controller


PUT
/api/customers/{id}/tier


GET
/api/customers


POST
/api/customers

Parameters
Cancel
Reset
No parameters

Request body

application/json
{
  "id": 1,
  "customerId": "string",
  "fullName": "string",
  "email": "string",
  "phone": "string",
  "currentTier": "string",
  "active": true,
  "createdAt": "2025-12-21T07:54:33.019Z"
}
Execute
Clear
Responses
Curl

curl -X 'POST' \
  'https://9189.408procr.amypo.ai/api/customers' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "id": 1,
  "customerId": "string",
  "fullName": "string",
  "email": "string",
  "phone": "string",
  "currentTier": "string",
  "active": true,
  "createdAt": "2025-12-21T07:54:33.019Z"
}'
Request URL
https://9189.408procr.amypo.ai/api/customers
Server response
Code	Details
500
Undocumented
Error: response status is 500

Response body
Download
{
  "timestamp": "2025-12-21T07:54:36.603+00:00",
  "status": 500,
  "error": "Internal Server Error",
  "path": "/api/customers"
}
Response headers
 content-type: application/json 
 date: Sun,21 Dec 2025 07:54:36 GMT 
 server: nginx/1.29.4 