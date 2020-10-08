<#import "partials/main.ftlh" as main>
<#import "partials/pager.ftlh" as p>
<@main.renderWith>
    <h2 class="mt-5">Users</h2>
    <div class="text-right">
        <a href="/users/register" class="btn btn-primary">New User</a>
    </div>
    <#if users.totalElements gt 5>
        <@p.pager url users/>
    </#if>
    <div class="list-group list-group-flush text-left w-25 justify-content-start my-5">
        <#list users.content as user>
            <a href="/users/detail/${user.id}" class="list-group-item list-group-item-action">${user.username}</a>
        </#list>
    </div>
    <#if users.totalElements gt 5>
        <@p.pager url users/>
    </#if>
</@main.renderWith>