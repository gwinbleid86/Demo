<#import "partials/main.ftlh" as main>
<@main.renderWith>
    <section id="page-splash" class="page-splash mt-5">
        <div class="d-flex justify-content-center">
            <div class="mx-3">
                <h3>Registration</h3>
                <form action="/register" method="post">
                    <#if _csrf??>
                        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}"
                               value="${(_csrf.token)!'--no-token--'}"/>
                    </#if>
                    <input type="text" name="username" class="form-control mb-1" value="${form.username!''}"
                           placeholder="Login"><br>
                    <input type="password" name="password" class="form-control mb-1" value="${form.password!''}"
                           placeholder="Password"><br>
                    <button class="btn btn-outline-primary btn-block" type="submit">Register</button>
                    <br>
                    <#if user?? >
                        <p>${user.name} already exists!</p>
                    </#if>
                </form>
            </div>
        </div>
    </section>
</@main.renderWith>
