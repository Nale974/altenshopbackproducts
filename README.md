# Alten shop back products

Projet back-end réalisé en Java SpringBoot pour un recrutement chez Alten SDC permettant la gestion de produits.

## Le back-end doit gérer les API REST suivantes :

| Resource              | POST                  | GET                            | PATCH                                    | PUT | DELETE           |
| --------------------- | --------------------- | ------------------------------ | ---------------------------------------- | --- | ---------------- |
| **/products**   | Create a new products | Retrieve all products          | X                                        | X   | X                |
| **/products/1** | X                     | Retrieve details for product 1 | Update details of product 1 if it exists | X   | Remove product 1 |

## Un produit a les caractéristiques suivantes :

```typescript
class Product {
  id: number;
  code: string;
  name: string;
  description: string;
  price: number;
  quantity: number;
  inventoryStatus: string;
  category: string;
  image?: string;
  rating?: number;
}
```

## Base de données

Le back-end créé doit pouvoir gérer les produits dans une base de données SQL/NoSQL ou dans un fichier json. J'ai choisi d'utiliser une base de données H2 intégrée à l'application Java pour lancer l'application sans dépendances à une base de données externe.

La base de données H2 est initialisée par la liste de produits disponible dans le fichier : `ressources/data/products.json`

## Utilisation de l'api

* Un front-end en Angular est disponible et permet d'utiliser l'API via cette adresse : `http://localhost:3000` et se lance avec avec la commande 'ng serve'
* [Collection Postman disponible ici](https://www.postman.com/maintenance-astronomer-76447758/workspace/nale974-public/collection/18100675-dff013ee-04f3-4a04-97ab-e09d620b53df?action=share&creator=18100675)

## Pistes d'amélioration

* Implémentation de Swagger avec test pour valider l'api
* Implémentation de tests unitaires avec **@WebMvcTest** et tests d'intégration avec **@SpringBootTest**
* Utilisation de docker pour lancer en parallèle une base de données SQL (mariaDB) ou noSQL(mongoDB)
