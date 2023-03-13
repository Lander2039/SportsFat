package com.example.sportsfat.data.repositoryImpl

import com.example.sportsfat.data.database.dao.DAO
import com.example.sportsfat.data.database.entity.ProductsEntity
import com.example.sportsfat.domain.model.ProductsModel
import com.example.sportsfat.domain.products.ProductsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val DAO: DAO
) : ProductsRepository {

    override suspend fun getData() {
        return withContext(Dispatchers.IO) {
            val response = getProducts()
            response.map { productsList ->
                val productsEntity =
                    ProductsEntity(
                        Random().nextInt(),
                        productsList.name,
                        productsList.calories,
                        productsList.squirrels,
                        productsList.fats,
                        productsList.carbohydrates
                    )
                DAO.insertProductsEntity(productsEntity)
            }
        }
    }

    override suspend fun showData(): Flow<List<ProductsModel>> {
        return withContext(Dispatchers.IO) {
            val productsEntity = DAO.getProductsEntities()
            productsEntity.map { productsList ->
                productsList.map {
                    ProductsModel(
                        it.name, it.calories, it.squirrels, it.fats, it.carbohydrates
                    )
                }
            }
        }
    }

    override suspend fun findProductByName(searchText: String): ProductsModel {
        return withContext(Dispatchers.IO) {
            val productsEntity = DAO.findProductsEntityByDescription(searchText)
            ProductsModel(
                productsEntity.name,
                productsEntity.calories,
                productsEntity.squirrels,
                productsEntity.fats,
                productsEntity.carbohydrates
            )
        }
    }

    fun getProducts(): List<ProductsModel> {
        val listProducts = listOf<ProductsModel>(
            ProductsModel(
                name = "Баклажаны",
                calories = 24.0,
                squirrels = 0.6,
                fats = 0.1,
                carbohydrates = 5.5
            ),
            ProductsModel(
                name = "Брюква",
                calories = 37.0,
                squirrels = 1.2,
                fats = 0.1,
                carbohydrates = 8.1
            ),
            ProductsModel(
                name = "Горошек зеленый",
                calories = 72.0,
                squirrels = 5.0,
                fats = 0.2,
                carbohydrates = 13.3
            ),
            ProductsModel(
                name = "Кабачки",
                calories = 27.0,
                squirrels = 0.6,
                fats = 0.3,
                carbohydrates = 5.7
            ),
            ProductsModel(
                name = "Капуста белокочанная",
                calories = 28.0,
                squirrels = 1.8,
                fats = 0.0,
                carbohydrates = 5.4
            ),
            ProductsModel(
                name = "Капустак раснокочанная",
                calories = 31.0,
                squirrels = 1.8,
                fats = 0.0,
                carbohydrates = 6.1
            ),
            ProductsModel(
                name = "Капуста цветная",
                calories = 29.0,
                squirrels = 2.5,
                fats = 0.0,
                carbohydrates = 4.9
            ),
            ProductsModel(
                name = "Картофель",
                calories = 83.0,
                squirrels = 2.0,
                fats = 0.0,
                carbohydrates = 19.7
            ),
            ProductsModel(
                name = "Лук зеленый(перо)",
                calories = 22.0,
                squirrels = 1.3,
                fats = 0.0,
                carbohydrates = 4.3
            ),
            ProductsModel(
                name = "Лук порей",
                calories = 40.0,
                squirrels = 3.0,
                fats = 0.0,
                carbohydrates = 7.3
            ),
            ProductsModel(
                name = "Лук репчатый",
                calories = 43.0,
                squirrels = 1.7,
                fats = 0.0,
                carbohydrates = 9.5
            ),
            ProductsModel(
                name = "Морковь красная",
                calories = 33.0,
                squirrels = 1.3,
                fats = 0.0,
                carbohydrates = 7.0
            ),
            ProductsModel(
                name = "Огурцы грунтовые",
                calories = 15.0,
                squirrels = 0.8,
                fats = 0.0,
                carbohydrates = 3.0
            ),
            ProductsModel(
                name = "Огурцы парниковые",
                calories = 10.0,
                squirrels = 0.7,
                fats = 0.0,
                carbohydrates = 1.8
            ),
            ProductsModel(
                name = "Перец зеленый сладкий",
                calories = 23.0,
                squirrels = 1.3,
                fats = 0.0,
                carbohydrates = 4.7
            ),
            ProductsModel(
                name = "Перец красный сладкий",
                calories = 27.0,
                squirrels = 1.3,
                fats = 0.0,
                carbohydrates = 5.7
            ),
            ProductsModel(
                name = "Петрушка(зелень)",
                calories = 45.0,
                squirrels = 3.7,
                fats = 0.0,
                carbohydrates = 8.1
            ),
            ProductsModel(
                name = "Петрушка(корень)",
                calories = 47.0,
                squirrels = 1.5,
                fats = 0.0,
                carbohydrates = 11.0
            ),
            ProductsModel(
                name = "Ревень(черешковый)",
                calories = 16.0,
                squirrels = 0.7,
                fats = 0.0,
                carbohydrates = 2.9
            ),
            ProductsModel(
                name = "Редис",
                calories = 20.0,
                squirrels = 1.2,
                fats = 0.0,
                carbohydrates = 4.1
            ),
            ProductsModel(
                name = "Редька",
                calories = 34.0,
                squirrels = 1.9,
                fats = 0.0,
                carbohydrates = 7.0
            ),
            ProductsModel(
                name = "Репа",
                calories = 28.0,
                squirrels = 1.5,
                fats = 0.0,
                carbohydrates = 5.9
            ),
            ProductsModel(
                name = "Салат",
                calories = 14.0,
                squirrels = 1.5,
                fats = 0.0,
                carbohydrates = 2.2
            ),
            ProductsModel(
                name = "Свекла",
                calories = 48.0,
                squirrels = 1.7,
                fats = 0.0,
                carbohydrates = 10.8
            ),
            ProductsModel(
                name = "Томаты(грунтовые)",
                calories = 19.0,
                squirrels = 0.6,
                fats = 0.0,
                carbohydrates = 4.2
            ),
            ProductsModel(
                name = "Томаты(парниковые)",
                calories = 14.0,
                squirrels = 0.6,
                fats = 0.0,
                carbohydrates = 2.9
            ),
            ProductsModel(
                name = "Зеленая фасоль(стручок)",
                calories = 32.0,
                squirrels = 4.0,
                fats = 0.0,
                carbohydrates = 4.3
            ),
            ProductsModel(
                name = "Хрен",
                calories = 71.0,
                squirrels = 2.5,
                fats = 0.0,
                carbohydrates = 16.3
            ),
            ProductsModel(
                name = "Черемша",
                calories = 34.0,
                squirrels = 2.4,
                fats = 0.0,
                carbohydrates = 6.5
            ),
            ProductsModel(
                name = "Чеснок",
                calories = 106.0,
                squirrels = 6.5,
                fats = 0.0,
                carbohydrates = 21.2
            ),
            ProductsModel(
                name = "Шпинат",
                calories = 21.0,
                squirrels = 2.9,
                fats = 0.0,
                carbohydrates = 2.3
            ),
            ProductsModel(
                name = "Щавель",
                calories = 28.0,
                squirrels = 1.5,
                fats = 0.0,
                carbohydrates = 5.3
            ),
            ProductsModel(
                name = "Абрикосы",
                calories = 46.0,
                squirrels = 0.9,
                fats = 0.0,
                carbohydrates = 10.5
            ),
            ProductsModel(
                name = "Айва",
                calories = 38.0,
                squirrels = 0.6,
                fats = 0.0,
                carbohydrates = 8.9
            ),
            ProductsModel(
                name = "Алыча",
                calories = 34.0,
                squirrels = 0.2,
                fats = 0.0,
                carbohydrates = 7.4
            ),
            ProductsModel(
                name = "Ананас",
                calories = 48.0,
                squirrels = 0.4,
                fats = 0.0,
                carbohydrates = 11.8
            ),
            ProductsModel(
                name = "Бананы",
                calories = 91.0,
                squirrels = 1.5,
                fats = 0.0,
                carbohydrates = 22.4
            ),
            ProductsModel(
                name = "Вишня",
                calories = 49.0,
                squirrels = 0.8,
                fats = 0.0,
                carbohydrates = 11.3
            ),
            ProductsModel(
                name = "Гранат",
                calories = 52.0,
                squirrels = 0.9,
                fats = 0.0,
                carbohydrates = 11.8
            ),
            ProductsModel(
                name = "Груша",
                calories = 42.0,
                squirrels = 0.4,
                fats = 0.0,
                carbohydrates = 10.7
            ),
            ProductsModel(
                name = "Инжир",
                calories = 56.0,
                squirrels = 0.7,
                fats = 0.0,
                carbohydrates = 13.9
            ),
            ProductsModel(
                name = "Кизил",
                calories = 45.0,
                squirrels = 1.0,
                fats = 0.0,
                carbohydrates = 9.7
            ),
            ProductsModel(
                name = "Персики",
                calories = 44.0,
                squirrels = 0.9,
                fats = 0.0,
                carbohydrates = 10.4
            ),
            ProductsModel(
                name = "Рябина садовая",
                calories = 58.0,
                squirrels = 1.4,
                fats = 0.0,
                carbohydrates = 12.5
            ),
            ProductsModel(
                name = "Рябина черноплодная",
                calories = 54.0,
                squirrels = 1.5,
                fats = 0.0,
                carbohydrates = 12.0
            ),
            ProductsModel(
                name = "Слива садовая",
                calories = 43.0,
                squirrels = 0.8,
                fats = 0.0,
                carbohydrates = 9.9
            ),
            ProductsModel(
                name = "Финики",
                calories = 281.0,
                squirrels = 2.5,
                fats = 0.0,
                carbohydrates = 72.1
            ),
            ProductsModel(
                name = "Хурма",
                calories = 62.0,
                squirrels = 0.5,
                fats = 0.0,
                carbohydrates = 15.9
            ),
            ProductsModel(
                name = "Черешня",
                calories = 52.0,
                squirrels = 1.1,
                fats = 0.0,
                carbohydrates = 12.3
            ),
            ProductsModel(
                name = "Шелковица",
                calories = 53.0,
                squirrels = 0.7,
                fats = 0.0,
                carbohydrates = 12.7
            ),
            ProductsModel(
                name = "Яблоки",
                calories = 46.0,
                squirrels = 0.4,
                fats = 0.0,
                carbohydrates = 11.3
            ),
            ProductsModel(
                name = "Апельсин",
                calories = 38.0,
                squirrels = 0.9,
                fats = 0.0,
                carbohydrates = 8.4
            ),
            ProductsModel(
                name = "Грейпфрут",
                calories = 35.0,
                squirrels = 0.9,
                fats = 0.0,
                carbohydrates = 7.3
            ),
            ProductsModel(
                name = "Лимон",
                calories = 31.0,
                squirrels = 0.9,
                fats = 0.0,
                carbohydrates = 3.6
            ),
            ProductsModel(
                name = "Мандарин",
                calories = 38.0,
                squirrels = 0.8,
                fats = 0.0,
                carbohydrates = 8.6
            ),
            ProductsModel(
                name = "Брусника",
                calories = 40.0,
                squirrels = 0.7,
                fats = 0.0,
                carbohydrates = 8.6
            ),
            ProductsModel(
                name = "Виноград",
                calories = 69.0,
                squirrels = 0.4,
                fats = 0.0,
                carbohydrates = 17.5
            ),
            ProductsModel(
                name = "Голубика",
                calories = 37.0,
                squirrels = 1.0,
                fats = 0.0,
                carbohydrates = 7.7
            ),
            ProductsModel(
                name = "Ежевика",
                calories = 33.0,
                squirrels = 2.0,
                fats = 0.0,
                carbohydrates = 5.3
            ),
            ProductsModel(
                name = "Земляника",
                calories = 41.0,
                squirrels = 1.8,
                fats = 0.0,
                carbohydrates = 8.1
            ),
            ProductsModel(
                name = "Клюква",
                calories = 28.0,
                squirrels = 0.5,
                fats = 0.0,
                carbohydrates = 4.8
            ),
            ProductsModel(
                name = "Крыжовник",
                calories = 44.0,
                squirrels = 0.7,
                fats = 0.0,
                carbohydrates = 9.9
            ),
            ProductsModel(
                name = "Малина",
                calories = 41.0,
                squirrels = 0.8,
                fats = 0.0,
                carbohydrates = 9.0
            ),
            ProductsModel(
                name = "Морошка",
                calories = 31.0,
                squirrels = 0.8,
                fats = 0.0,
                carbohydrates = 6.8
            ),
            ProductsModel(
                name = "Облепиха",
                calories = 30.0,
                squirrels = 0.9,
                fats = 0.0,
                carbohydrates = 5.5
            ),
            ProductsModel(
                name = "Смородина белая",
                calories = 39.0,
                squirrels = 0.3,
                fats = 0.0,
                carbohydrates = 8.7
            ),
            ProductsModel(
                name = "Смородина красная",
                calories = 38.0,
                squirrels = 0.6,
                fats = 0.0,
                carbohydrates = 8.0
            ),
            ProductsModel(
                name = "Смородина черная",
                calories = 40.0,
                squirrels = 1.0,
                fats = 0.0,
                carbohydrates = 8.0
            ),
            ProductsModel(
                name = "Черника",
                calories = 40.0,
                squirrels = 1.1,
                fats = 0.0,
                carbohydrates = 8.6
            ),
            ProductsModel(
                name = "Шиповник свежий",
                calories = 101.0,
                squirrels = 1.6,
                fats = 0.0,
                carbohydrates = 24.0
            ),
            ProductsModel(
                name = "Шиповник сушеный",
                calories = 253.0,
                squirrels = 4.0,
                fats = 0.0,
                carbohydrates = 60.0
            ),
            ProductsModel(
                name = "Урюк",
                calories = 278.0,
                squirrels = 5.0,
                fats = 0.0,
                carbohydrates = 67.5
            ),
            ProductsModel(
                name = "Курага",
                calories = 272.0,
                squirrels = 5.2,
                fats = 0.0,
                carbohydrates = 65.9
            ),
            ProductsModel(
                name = "Изюм",
                calories = 276.0,
                squirrels = 1.8,
                fats = 0.0,
                carbohydrates = 70.9
            ),
            ProductsModel(
                name = "Изюм кишмиш",
                calories = 279.0,
                squirrels = 2.3,
                fats = 0.0,
                carbohydrates = 71.2
            ),
            ProductsModel(
                name = "Вишня",
                calories = 292.0,
                squirrels = 1.5,
                fats = 0.0,
                carbohydrates = 73.0
            ),
            ProductsModel(
                name = "Груша",
                calories = 246.0,
                squirrels = 2.3,
                fats = 0.0,
                carbohydrates = 62.1
            ),
            ProductsModel(
                name = "Персики",
                calories = 275.0,
                squirrels = 3.0,
                fats = 0.0,
                carbohydrates = 68.5
            ),
            ProductsModel(
                name = "Чернослив",
                calories = 264.0,
                squirrels = 2.3,
                fats = 0.0,
                carbohydrates = 65.6
            ),
            ProductsModel(
                name = "Яблоки(суш)",
                calories = 273.0,
                squirrels = 3.2,
                fats = 0.0,
                carbohydrates = 68.0
            ),
            ProductsModel(
                name = "Мед",
                calories = 308.0,
                squirrels = 0.8,
                fats = 0.0,
                carbohydrates = 80.3
            ),
            ProductsModel(
                name = "Драже фруктовое",
                calories = 384.0,
                squirrels = 3.7,
                fats = 10.2,
                carbohydrates = 73.1
            ),
            ProductsModel(
                name = "Зефир",
                calories = 299.0,
                squirrels = 0.8,
                fats = 0.0,
                carbohydrates = 78.3
            ),
            ProductsModel(
                name = "Ирис",
                calories = 387.0,
                squirrels = 3.3,
                fats = 7.5,
                carbohydrates = 81.8
            ),
            ProductsModel(
                name = "Мармелад",
                calories = 296.0,
                squirrels = 0.0,
                fats = 0.1,
                carbohydrates = 77.7
            ),
            ProductsModel(
                name = "Карамель",
                calories = 296.0,
                squirrels = 0.0,
                fats = 0.1,
                carbohydrates = 77.7
            ),
            ProductsModel(
                name = "Конфеты шоколадом",
                calories = 396.0,
                squirrels = 2.9,
                fats = 10.7,
                carbohydrates = 76.6
            ),
            ProductsModel(
                name = "Пастила",
                calories = 305.0,
                squirrels = 0.5,
                fats = 0.0,
                carbohydrates = 80.4
            ),
            ProductsModel(
                name = "Сахар",
                calories = 374.0,
                squirrels = 0.3,
                fats = 0.0,
                carbohydrates = 99.5
            ),
            ProductsModel(
                name = "Халва тахинная",
                calories = 510.0,
                squirrels = 12.7,
                fats = 29.9,
                carbohydrates = 50.6
            ),
            ProductsModel(
                name = "Халва подсолнечная",
                calories = 516.0,
                squirrels = 11.6,
                fats = 29.7,
                carbohydrates = 54.0
            ),
            ProductsModel(
                name = "Шоколад темный",
                calories = 540.0,
                squirrels = 5.4,
                fats = 35.3,
                carbohydrates = 52.6
            ),
            ProductsModel(
                name = "Шоколад молочный",
                calories = 547.0,
                squirrels = 6.9,
                fats = 35.7,
                carbohydrates = 52.4
            ),
            ProductsModel(
                name = "Вафли фруктовыми начинками",
                calories = 342.0,
                squirrels = 3.2,
                fats = 2.8,
                carbohydrates = 80.1
            ),
            ProductsModel(
                name = "Вафли",
                calories = 530.0,
                squirrels = 3.4,
                fats = 30.2,
                carbohydrates = 64.7
            ),
            ProductsModel(
                name = "Пирожно еслоеное с кремом",
                calories = 544.0,
                squirrels = 5.4,
                fats = 38.6,
                carbohydrates = 46.4
            ),
            ProductsModel(
                name = "Пирожное слоеное с яблоком",
                calories = 454.0,
                squirrels = 5.7,
                fats = 25.6,
                carbohydrates = 52.7
            ),
            ProductsModel(
                name = "Пирожноебисквитноесфруктовойначинкой",
                calories = 344.0,
                squirrels = 4.7,
                fats = 9.3,
                carbohydrates = 84.4
            ),
            ProductsModel(
                name = "Пряники",
                calories = 336.0,
                squirrels = 4.8,
                fats = 2.8,
                carbohydrates = 77.7
            ),
            ProductsModel(
                name = "Торт бисквитный с фруктовой начинкой",
                calories = 386.0,
                squirrels = 4.7,
                fats = 20.0,
                carbohydrates = 49.8
            ),
            ProductsModel(
                name = "Торт миндальный",
                calories = 524.0,
                squirrels = 6.6,
                fats = 35.8,
                carbohydrates = 46.8
            ),
            ProductsModel(
                name = "Хлеб ржаной",
                calories = 214.0,
                squirrels = 4.7,
                fats = 0.7,
                carbohydrates = 49.8
            ),
            ProductsModel(
                name = "Хлеб пшеничный",
                calories = 254.0,
                squirrels = 7.7,
                fats = 2.4,
                carbohydrates = 53.4
            ),
            ProductsModel(
                name = "Сдобная выпечка",
                calories = 297.0,
                squirrels = 7.6,
                fats = 4.5,
                carbohydrates = 60.0
            ),
            ProductsModel(
                name = "Баранки",
                calories = 312.0,
                squirrels = 10.4,
                fats = 1.3,
                carbohydrates = 68.7
            ),
            ProductsModel(
                name = "Сушки",
                calories = 330.0,
                squirrels = 11.0,
                fats = 1.3,
                carbohydrates = 73.0
            ),
            ProductsModel(
                name = "Сухари пшеничные",
                calories = 331.0,
                squirrels = 11.2,
                fats = 1.4,
                carbohydrates = 72.4
            ),
            ProductsModel(
                name = "Сухари сливочные",
                calories = 397.0,
                squirrels = 8.5,
                fats = 10.6,
                carbohydrates = 71.3
            ),
            ProductsModel(
                name = "Мука пшеничная высшего сорта",
                calories = 327.0,
                squirrels = 10.3,
                fats = 0.9,
                carbohydrates = 74.2
            ),
            ProductsModel(
                name = "Мука пшеничная Iсорта",
                calories = 329.0,
                squirrels = 10.6,
                fats = 1.3,
                carbohydrates = 73.2
            ),
            ProductsModel(
                name = "Мука пшеничнаяIIсорта",
                calories = 328.0,
                squirrels = 11.7,
                fats = 1.8,
                carbohydrates = 70.8
            ),
            ProductsModel(
                name = "Мука ржаная",
                calories = 326.0,
                squirrels = 6.9,
                fats = 1.1,
                carbohydrates = 76.9
            ),
            ProductsModel(
                name = "Гречневая ядрица",
                calories = 329.0,
                squirrels = 12.6,
                fats = 2.6,
                carbohydrates = 68.0
            ),
            ProductsModel(
                name = "Гречневая продел",
                calories = 326.0,
                squirrels = 9.5,
                fats = 1.9,
                carbohydrates = 72.2
            ),
            ProductsModel(
                name = "Манная",
                calories = 326.0,
                squirrels = 11.3,
                fats = 0.7,
                carbohydrates = 73.3
            ),
            ProductsModel(
                name = "Овсяная",
                calories = 345.0,
                squirrels = 11.9,
                fats = 5.8,
                carbohydrates = 65.4
            ),
            ProductsModel(
                name = "Перловая",
                calories = 324.0,
                squirrels = 9.3,
                fats = 1.1,
                carbohydrates = 73.7
            ),
            ProductsModel(
                name = "Пшено",
                calories = 334.0,
                squirrels = 12.0,
                fats = 2.9,
                carbohydrates = 69.3
            ),
            ProductsModel(
                name = "Рисовая",
                calories = 323.0,
                squirrels = 7.0,
                fats = 0.6,
                carbohydrates = 73.7
            ),
            ProductsModel(
                name = "Пшеничная«Полтавская»",
                calories = 325.0,
                squirrels = 12.7,
                fats = 1.1,
                carbohydrates = 70.6
            ),
            ProductsModel(
                name = "Толокно",
                calories = 357.0,
                squirrels = 12.2,
                fats = 5.8,
                carbohydrates = 68.3
            ),
            ProductsModel(
                name = "Ячневая",
                calories = 322.0,
                squirrels = 10.4,
                fats = 1.3,
                carbohydrates = 71.7
            ),
            ProductsModel(
                name = "Геркулес",
                calories = 355.0,
                squirrels = 13.1,
                fats = 6.2,
                carbohydrates = 65.7
            ),
            ProductsModel(
                name = "Кукурузная",
                calories = 325.0,
                squirrels = 8.3,
                fats = 1.2,
                carbohydrates = 75.0
            ),
            ProductsModel(
                name = "Бобы",
                calories = 58.0,
                squirrels = 6.0,
                fats = 0.1,
                carbohydrates = 8.3
            ),
            ProductsModel(
                name = "Горох лущеный",
                calories = 323.0,
                squirrels = 23.0,
                fats = 1.6,
                carbohydrates = 57.7
            ),
            ProductsModel(
                name = "Горох цельный",
                calories = 303.0,
                squirrels = 23.0,
                fats = 1.2,
                carbohydrates = 53.3
            ),
            ProductsModel(
                name = "Соя",
                calories = 395.0,
                squirrels = 34.9,
                fats = 17.3,
                carbohydrates = 26.5
            ),
            ProductsModel(
                name = "Фасоль",
                calories = 309.0,
                squirrels = 22.3,
                fats = 1.7,
                carbohydrates = 54.5
            ),
            ProductsModel(
                name = "Чечевица",
                calories = 310.0,
                squirrels = 24.8,
                fats = 1.1,
                carbohydrates = 53.7
            ),
            ProductsModel(
                name = "Белые свежие",
                calories = 25.0,
                squirrels = 3.2,
                fats = 0.7,
                carbohydrates = 1.6
            ),
            ProductsModel(
                name = "Белые сушеные",
                calories = 209.0,
                squirrels = 27.6,
                fats = 6.8,
                carbohydrates = 10.0
            ),
            ProductsModel(
                name = "Подберезовикис вежие",
                calories = 31.0,
                squirrels = 2.3,
                fats = 0.9,
                carbohydrates = 3.7
            ),
            ProductsModel(
                name = "Подосиновики свежие",
                calories = 31.0,
                squirrels = 3.3,
                fats = 0.5,
                carbohydrates = 3.4
            ),
            ProductsModel(
                name = "Сыроежи свежие",
                calories = 17.0,
                squirrels = 1.7,
                fats = 0.3,
                carbohydrates = 1.4
            ),
            ProductsModel(
                name = "Баранина",
                calories = 203.0,
                squirrels = 16.3,
                fats = 15.3,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Говядина",
                calories = 187.0,
                squirrels = 18.9,
                fats = 12.4,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Конина",
                calories = 143.0,
                squirrels = 20.2,
                fats = 7.0,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Кролик",
                calories = 199.0,
                squirrels = 20.7,
                fats = 12.9,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Свинина нежирная",
                calories = 316.0,
                squirrels = 16.4,
                fats = 27.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Свинина жирная",
                calories = 489.0,
                squirrels = 11.4,
                fats = 49.3,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Телятина",
                calories = 90.0,
                squirrels = 19.7,
                fats = 1.2,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Бараньи Почки",
                calories = 77.0,
                squirrels = 13.6,
                fats = 2.5,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Баранья Печень",
                calories = 101.0,
                squirrels = 18.7,
                fats = 2.9,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Баранье Сердце",
                calories = 82.0,
                squirrels = 13.5,
                fats = 2.5,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Говяжьи Мозги",
                calories = 124.0,
                squirrels = 9.5,
                fats = 9.5,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Говяжья Печень",
                calories = 98.0,
                squirrels = 17.4,
                fats = 3.1,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Говяжьи Почки",
                calories = 66.0,
                squirrels = 12.5,
                fats = 1.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Говяжье Вымя",
                calories = 173.0,
                squirrels = 12.3,
                fats = 13.7,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Говяжье Сердце",
                calories = 87.0,
                squirrels = 15.0,
                fats = 3.0,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Говяжий язык",
                calories = 163.0,
                squirrels = 13.6,
                fats = 12.1,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Почки свинные",
                calories = 80.0,
                squirrels = 13.0,
                fats = 3.1,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Печень свинная",
                calories = 108.0,
                squirrels = 18.8,
                fats = 3.6,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Сердце свинное",
                calories = 89.0,
                squirrels = 15.1,
                fats = 3.2,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Язык свинной",
                calories = 208.0,
                squirrels = 14.2,
                fats = 16.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Гуси",
                calories = 364.0,
                squirrels = 16.1,
                fats = 33.3,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Индейка",
                calories = 197.0,
                squirrels = 21.6,
                fats = 12.0,
                carbohydrates = 0.8
            ),
            ProductsModel(
                name = "Куры",
                calories = 165.0,
                squirrels = 20.8,
                fats = 8.8,
                carbohydrates = 0.6
            ),
            ProductsModel(
                name = "Куриная грудка",
                calories = 113.0,
                squirrels = 23.6,
                fats = 1.9,
                carbohydrates = 0.4
            ),
            ProductsModel(
                name = "Цыплята",
                calories = 156.0,
                squirrels = 18.7,
                fats = 7.8,
                carbohydrates = 0.4
            ),
            ProductsModel(
                name = "Утки",
                calories = 346.0,
                squirrels = 16.5,
                fats = 61.2,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Варенаяколбаса Диабетическая",
                calories = 254.0,
                squirrels = 12.1,
                fats = 22.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Вареная колбаса Диетическая",
                calories = 170.0,
                squirrels = 12.1,
                fats = 13.5,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Вареная колбаса Докторская",
                calories = 260.0,
                squirrels = 13.7,
                fats = 22.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Вареная колбаса Любительская",
                calories = 301.0,
                squirrels = 12.2,
                fats = 28.0,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Вареная колбаса Молочная",
                calories = 252.0,
                squirrels = 11.7,
                fats = 22.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Вареная колбаса Отдельная",
                calories = 228.0,
                squirrels = 10.1,
                fats = 20.1,
                carbohydrates = 1.8
            ),
            ProductsModel(
                name = "Вареная колбаса Телячья",
                calories = 316.0,
                squirrels = 12.5,
                fats = 29.6,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Сардельки Свиные",
                calories = 332.0,
                squirrels = 10.1,
                fats = 31.6,
                carbohydrates = 1.9
            ),
            ProductsModel(
                name = "Сосиски Молочные",
                calories = 277.0,
                squirrels = 12.3,
                fats = 25.3,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Сосиски Русские",
                calories = 220.0,
                squirrels = 12.0,
                fats = 19.1,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Сосиски Свиные",
                calories = 324.0,
                squirrels = 11.8,
                fats = 30.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Варено-копченая Любительская",
                calories = 420.0,
                squirrels = 17.3,
                fats = 39.0,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Варено-копченая Сервелат",
                calories = 360.0,
                squirrels = 28.2,
                fats = 27.5,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Полукопченая Краковская",
                calories = 466.0,
                squirrels = 16.2,
                fats = 44.6,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Полукопченая Минская",
                calories = 259.0,
                squirrels = 23.0,
                fats = 17.4,
                carbohydrates = 2.7
            ),
            ProductsModel(
                name = "Полукопченая Полтавская",
                calories = 417.0,
                squirrels = 16.4,
                fats = 39.0,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Полукопченая Украинская",
                calories = 376.0,
                squirrels = 16.5,
                fats = 34.4,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Сырокопченая Любительская",
                calories = 514.0,
                squirrels = 20.9,
                fats = 47.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Сырокопченая Московская",
                calories = 473.0,
                squirrels = 24.8,
                fats = 41.5,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Говядина тушеная",
                calories = 232.0,
                squirrels = 16.8,
                fats = 18.3,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Завтрак туриста(говядина)",
                calories = 176.0,
                squirrels = 20.5,
                fats = 10.4,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Завтрак туриста(свинина)",
                calories = 206.0,
                squirrels = 16.9,
                fats = 15.4,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Колбасный фарш",
                calories = 213.0,
                squirrels = 15.2,
                fats = 15.7,
                carbohydrates = 2.8
            ),
            ProductsModel(
                name = "Свинина тушеная",
                calories = 349.0,
                squirrels = 14.9,
                fats = 32.2,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Грудинка сырокопченая",
                calories = 632.0,
                squirrels = 7.6,
                fats = 66.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Корейка сырокопченая",
                calories = 467.0,
                squirrels = 10.5,
                fats = 47.2,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Ветчина",
                calories = 279.0,
                squirrels = 22.6,
                fats = 20.9,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Жир бараний или говяжий топленый",
                calories = 897.0,
                squirrels = 0.0,
                fats = 99.7,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Шпик свиной",
                calories = 816.0,
                squirrels = 1.4,
                fats = 92.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Маргарин молочный",
                calories = 746.0,
                squirrels = 0.3,
                fats = 82.3,
                carbohydrates = 1.0
            ),
            ProductsModel(
                name = "Маргарин бутербродный",
                calories = 744.0,
                squirrels = 0.5,
                fats = 82.0,
                carbohydrates = 1.2
            ),
            ProductsModel(
                name = "Майонез",
                calories = 627.0,
                squirrels = 3.1,
                fats = 67.0,
                carbohydrates = 2.6
            ),
            ProductsModel(
                name = "Масло растительное",
                calories = 899.0,
                squirrels = 0.0,
                fats = 99.9,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Масло сливочное",
                calories = 748.0,
                squirrels = 0.6,
                fats = 82.5,
                carbohydrates = 0.9
            ),
            ProductsModel(
                name = "Масло топленое",
                calories = 887.0,
                squirrels = 0.3,
                fats = 98.0,
                carbohydrates = 0.6
            ),
            ProductsModel(
                name = "Брынза",
                calories = 260.0,
                squirrels = 17.9,
                fats = 20.1,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Йогурт 1.5%",
                calories = 51.0,
                squirrels = 5.0,
                fats = 1.5,
                carbohydrates = 3.5
            ),
            ProductsModel(
                name = "Кефир ",
                calories = 30.0,
                squirrels = 3.0,
                fats = 0.1,
                carbohydrates = 3.8
            ),
            ProductsModel(
                name = "Кефир жирный",
                calories = 59.0,
                squirrels = 2.8,
                fats = 3.2,
                carbohydrates = 4.1
            ),
            ProductsModel(
                name = "Молоко",
                calories = 58.0,
                squirrels = 2.8,
                fats = 3.2,
                carbohydrates = 4.7
            ),
            ProductsModel(
                name = "Молоко ацидофильное",
                calories = 83.0,
                squirrels = 2.8,
                fats = 3.2,
                carbohydrates = 10.8
            ),
            ProductsModel(
                name = "Молоко сухое цельное",
                calories = 475.0,
                squirrels = 25.6,
                fats = 25.0,
                carbohydrates = 39.4
            ),
            ProductsModel(
                name = "Молоко сгущеное",
                calories = 135.0,
                squirrels = 7.0,
                fats = 7.9,
                carbohydrates = 9.5
            ),
            ProductsModel(
                name = "Молоко сгущеное с сахаром",
                calories = 315.0,
                squirrels = 7.2,
                fats = 8.5,
                carbohydrates = 56.0
            ),
            ProductsModel(
                name = "Простокваша",
                calories = 58.0,
                squirrels = 2.8,
                fats = 3.2,
                carbohydrates = 4.1
            ),
            ProductsModel(
                name = "Ряженка",
                calories = 85.0,
                squirrels = 3.0,
                fats = 6.0,
                carbohydrates = 4.1
            ),
            ProductsModel(
                name = "Сливки 10%",
                calories = 118.0,
                squirrels = 3.0,
                fats = 10.0,
                carbohydrates = 4.0
            ),
            ProductsModel(
                name = "Сливки 20%",
                calories = 205.0,
                squirrels = 2.8,
                fats = 20.0,
                carbohydrates = 3.6
            ),
            ProductsModel(
                name = "Сметана 10%",
                calories = 116.0,
                squirrels = 3.0,
                fats = 10.0,
                carbohydrates = 2.9
            ),
            ProductsModel(
                name = "Сметана 20%",
                calories = 206.0,
                squirrels = 2.8,
                fats = 20.0,
                carbohydrates = 3.2
            ),
            ProductsModel(
                name = "Сырки",
                calories = 340.0,
                squirrels = 7.1,
                fats = 23.0,
                carbohydrates = 27.5
            ),
            ProductsModel(
                name = "Сыр российский",
                calories = 371.0,
                squirrels = 23.4,
                fats = 30.0,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Сыр голландский",
                calories = 361.0,
                squirrels = 26.8,
                fats = 27.3,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Сыр швейцарский",
                calories = 396.0,
                squirrels = 24.9,
                fats = 31.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Сыр пошехонский",
                calories = 334.0,
                squirrels = 26.0,
                fats = 26.5,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Сыр плавленный",
                calories = 226.0,
                squirrels = 24.0,
                fats = 13.5,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Творог жирный",
                calories = 226.0,
                squirrels = 14.0,
                fats = 18.0,
                carbohydrates = 1.3
            ),
            ProductsModel(
                name = "Творог полужирный",
                calories = 156.0,
                squirrels = 16.7,
                fats = 9.0,
                carbohydrates = 1.3
            ),
            ProductsModel(
                name = "Творог нежирный",
                calories = 86.0,
                squirrels = 18.0,
                fats = 0.6,
                carbohydrates = 1.5
            ),
            ProductsModel(
                name = "Яйцо куриное",
                calories = 157.0,
                squirrels = 12.7,
                fats = 11.5,
                carbohydrates = 0.7
            ),
            ProductsModel(
                name = "Яичный порошок",
                calories = 542.0,
                squirrels = 45.0,
                fats = 37.3,
                carbohydrates = 7.1
            ),
            ProductsModel(
                name = "Сухой белок",
                calories = 336.0,
                squirrels = 73.3,
                fats = 1.8,
                carbohydrates = 7.0
            ),
            ProductsModel(
                name = "Сухой желток",
                calories = 623.0,
                squirrels = 34.2,
                fats = 52.2,
                carbohydrates = 4.4
            ),
            ProductsModel(
                name = "Яйцо перепелиное",
                calories = 168.0,
                squirrels = 11.9,
                fats = 13.1,
                carbohydrates = 0.6
            ),
            ProductsModel(
                name = "Бычки",
                calories = 145.0,
                squirrels = 12.8,
                fats = 8.1,
                carbohydrates = 5.2
            ),
            ProductsModel(
                name = "Горбуша",
                calories = 147.0,
                squirrels = 21.0,
                fats = 7.0,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Камбала",
                calories = 88.0,
                squirrels = 16.1,
                fats = 2.6,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Карась",
                calories = 87.0,
                squirrels = 17.7,
                fats = 1.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Карп",
                calories = 96.0,
                squirrels = 16.0,
                fats = 3.6,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Кета",
                calories = 138.0,
                squirrels = 22.0,
                fats = 5.6,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Корюшка",
                calories = 91.0,
                squirrels = 15.5,
                fats = 3.2,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Ледяная",
                calories = 75.0,
                squirrels = 15.5,
                fats = 1.4,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Лещ",
                calories = 105.0,
                squirrels = 17.1,
                fats = 4.1,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Семга",
                calories = 219.0,
                squirrels = 20.8,
                fats = 15.1,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Макрурус",
                calories = 60.0,
                squirrels = 13.2,
                fats = 0.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Минога",
                calories = 166.0,
                squirrels = 13.2,
                fats = 11.9,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Минтай",
                calories = 70.0,
                squirrels = 14.7,
                fats = 0.7,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Мойва",
                calories = 157.0,
                squirrels = 15.9,
                fats = 11.5,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Навага",
                calories = 73.0,
                squirrels = 13.4,
                fats = 1.0,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Налим",
                calories = 81.0,
                squirrels = 16.1,
                fats = 0.6,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Нототениямраморная",
                calories = 156.0,
                squirrels = 18.8,
                fats = 10.7,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Окунь морской",
                calories = 117.0,
                squirrels = 17.6,
                fats = 5.2,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Окунь речной",
                calories = 82.0,
                squirrels = 18.5,
                fats = 0.9,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Осетр",
                calories = 164.0,
                squirrels = 16.4,
                fats = 10.9,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Палтус",
                calories = 103.0,
                squirrels = 18.9,
                fats = 3.0,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Путасса",
                calories = 72.0,
                squirrels = 16.1,
                fats = 0.9,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Рыба-сабля",
                calories = 110.0,
                squirrels = 20.3,
                fats = 3.2,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Рыбец каспийский",
                calories = 98.0,
                squirrels = 19.2,
                fats = 2.4,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Сазан",
                calories = 121.0,
                squirrels = 18.4,
                fats = 5.3,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Сайра крупная",
                calories = 262.0,
                squirrels = 18.6,
                fats = 20.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Сайра мелкая",
                calories = 143.0,
                squirrels = 20.4,
                fats = 0.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Салака",
                calories = 121.0,
                squirrels = 17.3,
                fats = 5.6,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Сельдь",
                calories = 242.0,
                squirrels = 17.7,
                fats = 19.5,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Сиг",
                calories = 144.0,
                squirrels = 19.0,
                fats = 7.5,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Скумбрия",
                calories = 153.0,
                squirrels = 18.0,
                fats = 9.0,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Сом",
                calories = 144.0,
                squirrels = 16.8,
                fats = 8.5,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Ставрида",
                calories = 119.0,
                squirrels = 18.5,
                fats = 5.0,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Стерлядь",
                calories = 320.0,
                squirrels = 17.0,
                fats = 6.1,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Судак",
                calories = 83.0,
                squirrels = 19.0,
                fats = 0.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Треска",
                calories = 75.0,
                squirrels = 17.5,
                fats = 0.6,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Тунец",
                calories = 96.0,
                squirrels = 22.7,
                fats = 0.7,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Уголь наярыба",
                calories = 158.0,
                squirrels = 13.2,
                fats = 11.6,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Угорь морской",
                calories = 94.0,
                squirrels = 19.1,
                fats = 1.9,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Угорь",
                calories = 333.0,
                squirrels = 14.5,
                fats = 30.5,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Хек",
                calories = 86.0,
                squirrels = 16.6,
                fats = 2.2,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Щука",
                calories = 82.0,
                squirrels = 18.8,
                fats = 0.7,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Язь",
                calories = 117.0,
                squirrels = 18.2,
                fats = 0.3,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Креветка",
                calories = 134.0,
                squirrels = 28.7,
                fats = 1.2,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Печень трески",
                calories = 613.0,
                squirrels = 4.2,
                fats = 65.7,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Кальмар",
                calories = 75.0,
                squirrels = 18.0,
                fats = 0.3,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Краб",
                calories = 69.0,
                squirrels = 16.0,
                fats = 0.5,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Креветка",
                calories = 83.0,
                squirrels = 18.0,
                fats = 0.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Морская капуста",
                calories = 5.0,
                squirrels = 0.9,
                fats = 0.2,
                carbohydrates = 3.0
            ),
            ProductsModel(
                name = "Паста«Океан»",
                calories = 137.0,
                squirrels = 18.9,
                fats = 6.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Трепанг",
                calories = 35.0,
                squirrels = 7.3,
                fats = 0.6,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Кеты зернистая",
                calories = 251.0,
                squirrels = 31.6,
                fats = 13.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Лещевая пробойная",
                calories = 142.0,
                squirrels = 24.7,
                fats = 4.8,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Минтаевая пробойная",
                calories = 131.0,
                squirrels = 28.4,
                fats = 1.9,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Осетровая зернистая",
                calories = 203.0,
                squirrels = 28.9,
                fats = 9.7,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Осетровая пробойная",
                calories = 123.0,
                squirrels = 36.0,
                fats = 10.2,
                carbohydrates = 0.0
            ),
            ProductsModel(
                name = "Фундук",
                calories = 704.0,
                squirrels = 16.1,
                fats = 66.9,
                carbohydrates = 9.9
            ),
            ProductsModel(
                name = "Миндаль",
                calories = 645.0,
                squirrels = 18.6,
                fats = 57.7,
                carbohydrates = 13.6
            ),
            ProductsModel(
                name = "Грецкий орех",
                calories = 648.0,
                squirrels = 13.8,
                fats = 61.3,
                carbohydrates = 10.2
            ),
            ProductsModel(
                name = "Арахис",
                calories = 548.0,
                squirrels = 26.3,
                fats = 45.2,
                carbohydrates = 9.7
            ),
            ProductsModel(
                name = "Семя подсолнечника",
                calories = 578.0,
                squirrels = 20.7,
                fats = 52.9,
                carbohydrates = 5.0
            ),
        )
        return listProducts
    }
}