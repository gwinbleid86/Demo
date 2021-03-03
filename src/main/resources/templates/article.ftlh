<#import "partials/main.ftlh" as main>
<@main.renderWith>

    <div class="jumbotron mt-5 pt-3">
        <p class="d-flex h6 justify-content-between">
        <span class="text-capitalize">
            Category: <a href="/categories/${article.categoryId}"><b>${category.title}</b></a>
        </span>
            <span>
            Published by <a class="text-capitalize"
                            href="/users/detail/${article.user.id}"><b>${article.user.username}</b></a>
            -- ${article.date!"--:--"}
        </span>
        </p>
        <hr class="my-3">
        <div class="d-flex justify-content-start mx-5">
            <#if article.imageOriginalName?has_content>
                <img src="${imgAsBase64}" alt="${article.imageOriginalName}">
            <#else>
                <img src="${noImage}" alt="${noImage}">
            </#if>

            <h1 class="flex-grow-1 text-capitalize ml-5">${article.title}</h1>
            <div class="d-flex align-items-end">
                <a class="mr-2" href="/articles/${article.id}/edit"><b>Edit</b></a>
                <#--                <a href="/articles/${article.id}/delete" data-bs-toggle="modal" data-bs-target="#deleteModal"><b>Delete</b></a>-->
                <#--                <button type="button" class="btn btn-link" data-bs-toggle="modal" data-bs-target="#exampleModal"-->
                <#--                        style="line-height: 1.3; padding: 1px 6px;"><b>Delete</b></button>-->
            </div>
        </div>
        <hr class="my-4">
        <p>${article.description}</p>
    </div>

    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
        Launch demo modal
    </button>


<#--    <!-- Modal &ndash;&gt;-->
<#--    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">-->
<#--        <div class="modal-dialog modal-dialog-centered">-->
<#--            <div class="modal-content">-->
<#--                <div class="modal-header">-->
<#--                    <h5 class="modal-title" id="exampleModalLabel">Confirm Action</h5>-->
<#--                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>-->
<#--                </div>-->
<#--                <div class="modal-footer">-->
<#--                    <button type="button" class="btn btn-secondary" id="myInput" data-bs-dismiss="modal">Cancel</button>-->
<#--                    <button type="button" class="btn btn-primary">Ok</button>-->
<#--                </div>-->
<#--            </div>-->
<#--        </div>-->
<#--    </div>-->



    <!-- Button trigger modal -->
<#--    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">-->
<#--        Launch demo modal-->
<#--    </button>-->

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    ...
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary">Save changes</button>
                </div>
            </div>
        </div>
    </div>
</@main.renderWith>
