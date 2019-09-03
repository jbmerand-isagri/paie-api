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

## Les requêtes en back pour...

### Récupérer des données
  
#### Récupérer la liste des grades
- [GET] /grades
```JSON
{
    "code" : "GRADE_A",
    "nbHeuresBase" : 152.00,
    "tauxBase" : 11.00
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

### Ajouter un employé (=une rémunération employé)

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
    
ECHEC : {message correspond au type d'erreur}
```