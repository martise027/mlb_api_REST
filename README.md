# mlb_api_REST
# mlb_api
<p style="display: inline">
    <img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white">
    <img src="https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white">
    <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white">
</p>

![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

## introduction
This is mlb API that return mlb players data based on 2024 hitting. 
This data also include pitcher.

## Usage
this is base url for api.
```bash
https://mlb-api.onrender.com/api/v1/player
```

```bash
# return player who's position is DH
https://mlb-api.onrender.com/api/v1/player?position=DH

# return player who have hit more than 30 homerun
https://mlb-api.onrender.com/api/v1/player?homerun=30

# return player who have hit homerun more 20 and position is SS
https://mlb-api.onrender.com/api/v1/player?position=SS&homerun=30

# return player who belong to LAD and have hit more than 20 homerun
https://mlb-api.onrender.com/api/v1/player?team=LAD&homerun=20
```
### List of available filter
```bash
team
position
gamePlayed
hit
doubleHit
tripleHit
homerun
AVG
OPS
```

## app structure

# mlb_api_rest
