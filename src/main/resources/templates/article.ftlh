<#import "partials/main.ftlh" as main>
<@main.renderWith>

    <div class="jumbotron mt-5 pt-3">
        <p class="d-flex h6 justify-content-between">
        <span class="text-capitalize">
            Category: <a href="/categories/${article.category.id}"><b>${article.category.title}</b></a>
        </span>
            <span>
            Published by <a class="text-capitalize"
                            href="/users/detail/${article.user.id}"><b>${article.user.username}</b></a>
            -- ${article.date}
        </span>
        </p>
        <hr class="my-3">
        <div class="d-flex justify-content-start mx-5">
            <#if article.image?has_content>
                <img src="${imageUrl}" alt="${article.image}">
            <#else>
                <img src="${noImage}" alt="${noImage}">
            </#if>

            <h1 class="display-4 text-capitalize ml-5">${article.title}</h1>
        </div>
        <hr class="my-4">
        <p>${article.description}</p>
    </div>
</@main.renderWith>
