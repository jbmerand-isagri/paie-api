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
- [POST] crée une rémunération employé (JSON)
- [GET] récupérer la liste des employés (rémunérations employé) (JSON)

http://jbmerand-paie-api.herokuapp.com/bulletins_salaire
- [POST] crée un bulletin de salaire (JSON)
- [GET] affiche la liste des bulletins de salaire (JSON)

http://jbmerand-paie-api.herokuapp.com/bulletins_salaire/{idDuBulletinDeSalaire}
- [GET] affiche les données d'une feuille de bulletin de salaire (JSON)

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

```
200

[
  {
    "id": 1,
    "dateDebut": "2019-01-01",
    "dateFin": "2019-01-31",
    "primeExceptionnelle": 54.56,
    "dateHeureCreation": "2019-09-04T12:19:37.898+02:00",
    "matriculeCode": "ad571e9b-e0f0-4676-b2cd-fae1a4cb73fb",
    "salaireBrut": 3246.56,
    "netImposable": 2999.83,
    "netAPayer": 2912.83
  }
]
```

### Afficher les données d'une feuille de bulletin de salaire

Requête :

[GET] http://jbmerand-paie-api.herokuapp.com/bulletins_salaire/{idDuBulletinDeSalaire}

Réponse en cas de réussite :

```
200

{
  "salaire": {
    "id": 1,
    "dateDebut": "2019-01-01",
    "dateFin": "2019-01-31",
    "primeExceptionnelle": 54.56,
    "dateHeureCreation": "2019-09-04T16:32:04.074+02:00",
    "matriculeCode": "e4450752-1609-40cf-96a2-679145423650",
    "salaireBrut": 3246.56,
    "netImposable": 2999.83,
    "netAPayer": 2912.84,
    "baseSalaireDeBase": 152.00,
    "tauxSalarialSalaireDeBase": 21.00,
    "montantSalarialSalaireDeBase": 3192.00
  },
  "employe": {
    "matricule": "e4450752-1609-40cf-96a2-679145423650",
    "nom": "Durand",
    "prenoms": "Oliver, Pierre",
    "dateDeNaissance": "1980-02-29"
  },
  "cotisationsNonImposables": {
    "cotisations": [
      {
        "code": "EP01",
        "libelle": "URSSAF MALADIE - MATERNITE - INVALIDITE",
        "tauxSalarial": 0.007500,
        "tauxPatronal": 0.128000,
        "montantSalarial": 24.34920000,
        "cotisationsPatronales": 415.55968000,
        "base": 3246.56
      },
      {
        "code": "EP02",
        "libelle": "URSSAF SOLIDARITE",
        "tauxSalarial": 0,
        "tauxPatronal": 0.003000,
        "montantSalarial": 0.00,
        "cotisationsPatronales": 9.73968000,
        "base": 3246.56
      },
      {
        "code": "EP03",
        "libelle": "URSSAF ACCIDENT DU TRAVAIL",
        "tauxSalarial": 0,
        "tauxPatronal": 0.012000,
        "montantSalarial": 0.00,
        "cotisationsPatronales": 38.95872000,
        "base": 3246.56
      },
      {
        "code": "EP04",
        "libelle": "URSSAF ALLOC. FAMILIALES",
        "tauxSalarial": 0,
        "tauxPatronal": 0.054000,
        "montantSalarial": 0.00,
        "cotisationsPatronales": 175.31424000,
        "base": 3246.56
      },
      {
        "code": "EP05",
        "libelle": "URSSAF ASS. VIEILLESSE PLAF.",
        "tauxSalarial": 0.067500,
        "tauxPatronal": 0.084000,
        "montantSalarial": 219.14280000,
        "cotisationsPatronales": 272.71104000,
        "base": 3246.56
      },
      {
        "code": "EP06",
        "libelle": "URSSAF ASS. VIEILLESSE DEPLAF.",
        "tauxSalarial": 0.001000,
        "tauxPatronal": 0.016000,
        "montantSalarial": 3.24656000,
        "cotisationsPatronales": 51.94496000,
        "base": 3246.56
      },
      {
        "code": "EP07",
        "libelle": "URSSAF FNAL",
        "tauxSalarial": 0,
        "tauxPatronal": 0.001000,
        "montantSalarial": 0.00,
        "cotisationsPatronales": 3.24656000,
        "base": 3246.56
      },
      {
        "code": "SP01",
        "libelle": "URSSAF CSG NON DEDUCTIBLE",
        "tauxSalarial": 0.024000,
        "tauxPatronal": 0,
        "montantSalarial": 77.91744000,
        "cotisationsPatronales": 0.00,
        "base": 3246.56
      },
      {
        "code": "SP02",
        "libelle": "URSSAF CRDS",
        "tauxSalarial": 0.005000,
        "tauxPatronal": 0,
        "montantSalarial": 16.23280000,
        "cotisationsPatronales": 0.00,
        "base": 3246.56
      }
    ],
    "totalRetenueMontantSalarial": 246.73856000,
    "totalRetenueCotisationsPatronales": 967.47488000
  },
  "cotisationsImposables": [
    {
      "code": "EP01",
      "libelle": "URSSAF MALADIE - MATERNITE - INVALIDITE",
      "tauxSalarial": 0.007500,
      "tauxPatronal": 0.128000,
      "montantSalarial": 24.34920000,
      "cotisationsPatronales": 415.55968000,
      "base": 3246.56
    },
    {
      "code": "EP02",
      "libelle": "URSSAF SOLIDARITE",
      "tauxSalarial": 0,
      "tauxPatronal": 0.003000,
      "montantSalarial": 0.00,
      "cotisationsPatronales": 9.73968000,
      "base": 3246.56
    },
    {
      "code": "EP03",
      "libelle": "URSSAF ACCIDENT DU TRAVAIL",
      "tauxSalarial": 0,
      "tauxPatronal": 0.012000,
      "montantSalarial": 0.00,
      "cotisationsPatronales": 38.95872000,
      "base": 3246.56
    },
    {
      "code": "EP04",
      "libelle": "URSSAF ALLOC. FAMILIALES",
      "tauxSalarial": 0,
      "tauxPatronal": 0.054000,
      "montantSalarial": 0.00,
      "cotisationsPatronales": 175.31424000,
      "base": 3246.56
    },
    {
      "code": "EP05",
      "libelle": "URSSAF ASS. VIEILLESSE PLAF.",
      "tauxSalarial": 0.067500,
      "tauxPatronal": 0.084000,
      "montantSalarial": 219.14280000,
      "cotisationsPatronales": 272.71104000,
      "base": 3246.56
    },
    {
      "code": "EP06",
      "libelle": "URSSAF ASS. VIEILLESSE DEPLAF.",
      "tauxSalarial": 0.001000,
      "tauxPatronal": 0.016000,
      "montantSalarial": 3.24656000,
      "cotisationsPatronales": 51.94496000,
      "base": 3246.56
    },
    {
      "code": "EP07",
      "libelle": "URSSAF FNAL",
      "tauxSalarial": 0,
      "tauxPatronal": 0.001000,
      "montantSalarial": 0.00,
      "cotisationsPatronales": 3.24656000,
      "base": 3246.56
    },
    {
      "code": "SP01",
      "libelle": "URSSAF CSG NON DEDUCTIBLE",
      "tauxSalarial": 0.024000,
      "tauxPatronal": 0,
      "montantSalarial": 77.91744000,
      "cotisationsPatronales": 0.00,
      "base": 3246.56
    },
    {
      "code": "SP02",
      "libelle": "URSSAF CRDS",
      "tauxSalarial": 0.005000,
      "tauxPatronal": 0,
      "montantSalarial": 16.23280000,
      "cotisationsPatronales": 0.00,
      "base": 3246.56
    }
  ]
}
```

Réponse en cas d'échec :

```
404

ERREUR : id non trouvé dans la base de données.
```