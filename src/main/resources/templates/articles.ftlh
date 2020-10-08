<#import "partials/main.ftlh" as main>
<#import "partials/pager.ftlh" as p>
<@main.renderWith>

    <h2 class="mt-5">Все статьи</h2>

    <div>
        <div class="my-5">
            <a href="/articles/create" class="btn btn-primary">New Article</a>
        </div>
        <#if articles.totalElements gt 5>
            <@p.pager url articles/>
        </#if>
        <table class="table table-hover mt-5">
            <thead>
            <tr class="table-info">
                <th scope="col">Title</th>
                <th scope="col">Author</th>
                <th scope="col">Created</th>
            </tr>
            </thead>
            <#if articles.totalElements gt 5>
                <tfoot>
                <tr class="table-info">
                    <th scope="col">Title</th>
                    <th scope="col">Author</th>
                    <th scope="col">Created</th>
                </tr>

                </tfoot>
            </#if>
            <tbody>
            <#list articles.content as article>
                <tr class="btn-link" data-href="/articles/${article.id}">
                    <td>${article.title}</td>
                    <td>${article.user.username}</td>
                    <td>${article.date}</td>
                </tr>
            </#list>
            </tbody>
        </table>
        <#if articles.totalElements gt 5>
            <@p.pager url articles/>
        </#if>
    </div>

    <script>
        // jQuery( function($) {
        $('tbody tr[data-href]').addClass('clickable').click(function () {
            window.location = $(this).attr('data-href');
        });
        // });
    </script>

</@main.renderWith>
