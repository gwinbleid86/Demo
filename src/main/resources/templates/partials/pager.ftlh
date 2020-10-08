<#macro pager url collection>
    <div>
        <ul class="pagination justify-content-end">
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
            </li>
            <#list 1..collection.getTotalPages() as p>
                <#if (p-1)==collection.getNumber()>
                    <li
                            class="page-item active"
                            aria-current="page"
                    >
                        <a
                                class="page-link"
                                href="#"
                        >
                            ${p}
                        </a>
                    </li>
                <#else>
                    <li
                            class="page-item"
                            aria-current="page"
                    >
                        <a
                                class="page-link"
                                href="${url}/page=${p-1}"
                        >
                            ${p}
                        </a>
                    </li>
                </#if>
            </#list>
            <li class="page-item">
                <a class="page-link" href="#">Next</a>
            </li>
        </ul>
    </div>
</#macro>