Тестовое задание

Необходимо реализовать веб-приложение - административную панель для мобильного новостного клиента.


Основные сущности и их поля:

    Category
        -id
        -title
        -parent_id
    Article
        -id
        -category_id
        -user_id
        -title
        -description
        -image
    User
        -id
        -username
        -password

Ни одну часть приложения нельзя просматривать незалогиненному пользователю.

Каждую сущность (в том числе и пользователей) нужно иметь возможность:

    -Добавлять
    -Просматривать список
    -Редактировать
    -Удалять

Предоставьте отдельные эндпоинты, или используйте уже существующие, для возможности получения в JSON-формате списков категорий и статей (напр. GET /categories, GET /articles) незалогиненным пользователям (клиентам).
