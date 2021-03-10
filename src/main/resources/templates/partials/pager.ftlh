<#macro pager url collection>
    <#if collection.getTotalPages() gt 7>
        <#assign
            totalPages = collection.getTotalPages()
            pageNumber = collection.getNumber()+1
            head = (pageNumber > 4)?then([1, -1], [1, 2, 3])
            tail = (pageNumber < totalPages - 3)?then([-1, totalPages], [totalPages-2, totalPages-1, totalPages])
            bodyBefore = (pageNumber > 4 && pageNumber < totalPages - 1)?then([pageNumber-2, pageNumber-1], [])
            bodyAfter = (pageNumber > 2 && pageNumber < totalPages - 3)?then([pageNumber+1, pageNumber+2], [])

            body = head + bodyBefore + (pageNumber > 3 && pageNumber < totalPages - 2)?then([pageNumber], []) + bodyAfter + tail
        >
    <#else>
        <#assign body = 1..collection.getTotalPages()>
    </#if>
    <div>
        <nav>
            <ul class="pagination justify-content-end">
                <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1">Pages</a>
                </li>
                <#list body as p>
                    <#if (p-1)==collection.getNumber()>
                        <li class="page-item active" aria-current="page">
                            <a class="page-link" href="#">${p}</a>
                        </li>
                    <#elseif p==-1>
                        <li class="page-item disabled" aria-current="page">
                            <a class="page-link" href="#">...</a>
                        </li>
                    <#else>
                        <li class="page-item" aria-current="page">
                            <a class="page-link" href="${url}?page=${p-1}">${p}</a>
                        </li>
                    </#if>
                </#list>
            </ul>
        </nav>
    </div>
</#macro>