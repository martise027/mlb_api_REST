# MLB REST API
<p style="display: inline">
    <img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white">
    <img src="https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white">
    <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white">
</p>

![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)


## introduction
This is mlb API that return mlb players data based on 2024 hitting. 
This data also include pitcher.

Also allowed user to send GET,POST,PUT,DELETE request.

## Usage
this is base url for api.
```bash
https://mlb-api-rest.onrender.com/api/v2/player
```

```bash
# return player who's position is DH
https://mlb-api-rest.onrender.com/api/v2/player?name=Ohtani

# return player who have hit more than 30 homerun
https://mlb-api-rest.onrender.com/api/v1/player?homerunmore=30

# return player who have hit homerun more 20 and position is SS
https://mlb-api-rest.onrender.com/api/v1/player?position=SS&homerunmore=30

# return player who belong to LAD and have hit more than 20 homerun
https://mlb-api-rest.onrender.com/api/v1/player?team=LAD&homerunmore=20

```
### List of available filter
```bash
name
team
position
game (game number player has played)
hitmore (hit more than )
hitless (hit less than)
dHit (double hit)
tHit (triple hit)
homerunmore (homerun more than)
homerunless (homerun less than)
```

### JSON format
#### Plase follow this format if you send POST, PUT request. 
```bash
 {
        "name": "name",
        "team": "team",
        "position": "position",
        "g": 0,
        "r": 0,
        "h": 0,
        "dHits": 0,
        "tHits": 0,
        "homerun": 0,
        "ab": 0,
        "rbi": 0,
        "bb": 0,
        "so": 0,
        "sb": 0,
        "cs": 0,
        "avg": 0.000,
        "obp": 0.000,
        "slg": 0.000,
        "ops": 1.000
    }
```


## app structure

```
API/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── rest_api/
│   │   │               ├── RestApiApplication.java
│   │   │               ├──mlb_api
│   │   │                   └── PlayerController.java
│   │   │                   └── PlayerService.java
│   │   │                   └── PlayerRepository.java
│   │   │                   └── Player.java
│   │   │             
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   └── static/ 
│   │   │   └── templates/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── api/
│       │               └── (test files)
│       └── resources/
│           └── (test resource files)
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```


