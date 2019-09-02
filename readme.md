# paie-api

API déployée sur HEROKU.

## Listes des requêtes

http://jbmerand-paie-api.herokuapp.com/entreprises
- [GET] donne la liste simplifiée des entreprises (JSON)
- [POST] crée un employé (depuis du JSON)

http://jbmerand-paie-api.herokuapp.com/grades
- [GET] donne la liste des grades (JSON)

http://jbmerand-paie-api.herokuapp.com/profils
- [GET] donne la liste des profils (JSON)

http://jbmerand-paie-api.herokuapp.com/remuneration_employes
- [POST] crée l'employe
- [GET] donne la liste des rémunération des employés (JSON)

## Les requêtes en back pour...

### Ajouter un employé
  
1) [GET] http://jbmerand-paie-api.herokuapp.com/remuneration_employes
Déclenche :
    - [GET] /grades : gradeService.recupererGrades() qui va solliciter GradeRepository
        ```JSON
        [
          {
             "grade" : "GRADE_A",
             "nbHeuresBase" : 152,
             "tauxBase" : 11
          }, // ...
        ]
        ```
    - [GET] /profils : profileService.recupererProfilsRemuneration()
        ```JSON
        [
          {
             "id" : 1,
             "code" : "Technicien"
          }, // ...
        ]
        ```
    - [GET] /entreprises : entrepriseService.recupererEntreprises()
       ```JSON
        [
          {
             "code" : 'DEV',
             "denomination" : "Dev Institut"
          }, // ...
        ]
        ```
2) [POST] http://jbmerand-paie-api.herokuapp.com/remuneration_employes
    - exemple de JSON envoyé :
    ```JSON
    {
      "matricule" : "cvdfg",
      "entreprise" : 23, // id de l'entreprise
      "profilRemuneration" : 2, // id
      "grade" : "GRADE_A"
    }
    ```

En cas d'erreur, un JSON est renvoyé avec le corps et le code de la réponse est 404 :
```json
{
  "message" : "Erreur de ..." // message de l'erreur
}
```