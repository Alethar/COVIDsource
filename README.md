Repository for team 2147 in the 2020 Geom Hacks Hackathon.

To get started, download the .zip file called COVIDsourceFINAL.zip



## Overall Idea/Motivation for the Project
In our current world, finding accurate and unbiased information is becoming a pressing issue. It's often difficult to check the validity of information. We decided we wanted to build a tool to help people research, verify, and sort news articles.

## What it does
Our project allows people to search for news articles. Articles from sources within our database will be given a credibility and bias rating based on a third party website. The application also allows you to set and mark goals (such as # of reputable news sources found) and save articles into a list for reference.

## How the Project Was Built, and the Tools We Used
The project runs on java, and searches google for relevant results and displays news articles in a navigable format. Any article authors/hosts that match news organizations in our databased are marked with a corresponding credibility/bias rating, which is displayed on the user interface. 

Jsoup was used to take html from google search pages, and each page was filtered to find results. News pages are prioritized, but other links are also added to the search.

The app loads 30 responses per search, allowing the user to sort through and identify articles they might be interested in. They choose to open articles in their browser by clicking on them, or sort them into a list of saved articles. They can also customize and remove/finish a list of goals on the top right of the UI.

Although many sources do not have a rating, we hope that we can pull more data in usable formats from 3rd party media rating websites in order to better provide info about online web sources.
