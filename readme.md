# paie-api

API déployée sur HEROKU.

## Listes des requêtes

http://jbmerand-paie-api.herokuapp.com/entreprises
- [GET] donne la liste simplifiée des entreprises (JSON)

http://jbmerand-paie-api.herokuapp.com/grades
- [GET] donne la liste des grades (JSON)

http://jbmerand-paie-api.herokuapp.com/profils_remuneration
- [GET] donne la liste des profils (JSON)

http://jbmerand-paie-api.herokuapp.com/remuneration_employes
- [POST] crée une rémunération employé
- [GET] récupérer la liste des employés (rémunérations employé)

http://jbmerand-paie-api.herokuapp.com/bulletins_salaire
- [POST] crée un bulletin de salaire

## Les requêtes en back pour...

### Récupérer des données

Réussite :  
```
200
```
Echec :
```
404
```

#### Récupérer la liste des grades
- [GET] /grades
```JSON
{
    "code" : "GRADE_A",
    "nbHeuresBase" : 152.00,
    "tauxBase" : 11.00
}
```

### Récupérer la liste des employés (rémunérations employé)

- [GET] /remuneration_employes
```JSON
{
    "dateDeCreation" : "2019-09-03 13:50:56.78",
    "matricule" : "M0111",
    "gradeCode" : "GRADE_A"
}
```

#### Récupérer la liste des profils de rémunération
- [GET] /profils_remuneration
```JSON
{
    "code" : "Technicien"
}
```

#### Récupérer la liste épurée des entreprises
- [GET] /entreprises
```JSON
{
    "code" : "DEV",
    "denomination" : "Dev Institut"
}
```

### Ajouter un employé (= une rémunération employé)

Requête  :

[POST] http://jbmerand-paie-api.herokuapp.com/remuneration_employes
```JSON
{
    "matricule" : "HJS-JS-56",
    "entrepriseCode" : "DEV",
    "profilRemunerationCode" : "Technicien",
    "gradeCode" : "GRADE_A"
}
```

Réponse en cas de réussite :
```
201

SUCCES : l'employé a bien été ajouté.

```
Réponse en cas d'erreur :

```
404
    
ECHEC : {message correspond au type d'erreur recontré}
```

### Créer/insérer un bulletin de salaire

Requête  :

[POST] http://jbmerand-paie-api.herokuapp.com/bulletins_salaire
```JSON
{
    "periodeId" : "2",
    "matriculeCode" : "HJS-JS-56",
    "primeExceptionnelle" : "300.23"
}
```

Réponse en cas de réussite :
```
201

SUCCES : le bulletin a été créé.

```
Réponse en cas d'erreur :

```
404
    
ECHEC : {message correspond au type d'erreur recontré}
```

### Afficher les bulletins de salaire

Requête :

[GET] http://jbmerand-paie-api.herokuapp.com/bulletins_salaire


Réponse en cas de réussite :
````
200

[
  {
    "dateDebut": "2019-02-01",
    "dateFin": "2019-02-28",
    "primeExceptionnelle": 876.00,
    "dateHeureCreation": "2019-09-04T11:56:31.697+02:00",
    "matriculeCode": "0a5d0a48-993a-4b1f-aa14-9b1a2d87a056",
    "salaireBrut": 2548.00,
    "netImposable": 2354.35,
    "netAPayer": 2286.75
  },
  {
    "dateDebut": "2019-01-01",
    "dateFin": "2019-01-31",
    "primeExceptionnelle": 54.56,
    "dateHeureCreation": "2019-09-04T11:57:08.658+02:00",
    "matriculeCode": "ad571e9b-e0f0-4676-b2cd-fae1a4cb73fb",
    "salaireBrut": 3246.5600,
    "netImposable": 2999.82,
    "netAPayer": 2912.82
  }
]
```