<#import "partials/main.ftlh" as main>
<#import "partials/pager.ftlh" as p>
<@main.renderWith>
    <div class="jumbotron text-left">
        <h1 class="display-4">${user.get().username}</h1>
        <hr class="my-4">
        <a class="btn btn-primary btn-lg" href="#" role="button">Delete User</a>
    </div>
    <@p.pager url articles/>
    <div class="list-group list-group-flush text-left justify-content-start">
        <#list articles.content as article>
            <a href="/articles/${article.id}" class="list-group-item list-group-item-action">
                <div class="jumbotron">
<#--                    <img src="${article.image}" class="card-img-top" alt="${article.title}">-->
                    <h1 class="display-4">${article.title}</h1>
                    <hr class="my-4">
                    <p>${article.description}</p>
                </div>
            </a>
        </#list>
    </div>
    <@p.pager url articles/>
</@main.renderWith>