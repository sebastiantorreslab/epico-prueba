# epico-prueba
prueba técnica spring boot - Epico-Software

# 1. Inicializar MySql en docker
``` shell
docker run --detach --name mysql --env MYSQL_ROOT_PASSWORD=root-db --volume mysql:/var/lib/mysql --publish 3306:3306 mysql
``` 
# 2. Conectarse con MySql workbench

``` 
user=root
password=root-db
host=localhost
port=3306
``` 
# 3. Una vez conectados a epico-bd crear la base de datos en mySql

``` 
CREATE DATABASE epico-bd;
``` 
# 4. Para efectos prácticos puede correrse la colección en postman que prueba la api

``` 
Postman
1.Crear categoría -> http://localhost:8080/category/save
    Body - JSON
    {
    "categoryName":"CANDY",
    "categoryDescription":"candy-snacks",
    "categoryPic":"https://img.freepik.com/vector-gratis/coleccion-snacks_23-2147914464.jpg?w=2000",
    "items":[]
    }
2.Crear productos -> http://localhost:8080/item/save
 Body - JSON
 {
    "name":"cocacola",
    "category_id": 1,
    "costPrice": 2500,
    "unitPrice": 7000,
    "picFilename":"https://lavaquita.co/cdn/shop/products/supermercados_la_vaquita_supervaquita_gaseosa_coca_cola_10_oz_bebidas_liquidas_700x700.jpg?v=1620489361",
    "sku":"sd-5647",
    "available": true
   
}

-Se debe crear categoría primero ya que al momento de crear el producto, se proporciona el id de la categoría donde quedará relacionado.
-Se decide trabajar con categorias como tabla para brindar mejor funcionamiento para la persistencia de datos, así como la renderización en frontend
``` 
Enlace postman: [Coleccion - Postman](EPICO-SOFTWARE.postman_collection.json)



