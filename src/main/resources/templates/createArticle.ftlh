<#import "partials/main.ftlh" as main>
<@main.renderWith>
    <script>
        $(function () {
            bsCustomFileInput.init()
        })
    </script>
    <div>
        <h2>Create a new article</h2>

        <form action="/articles/create" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">Title:</span>
                    </div>
                    <input type="text" class="form-control" aria-label="Title" aria-describedby="basic-addon1"
                           name="title" required>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="inputGroupFile"
                               aria-describedby="inputGroupFileAddon" name="image">
                        <label class="custom-file-label" for="inputGroupFile">Choose file</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <select name="categoryId" class="form-control">
                    <option value="0">Chose the Category</option>
                    <#list categories as category>
                        <option value=${category.id}>${category.title}, ${category.id}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Description:</span>
                    </div>
                    <textarea class="form-control" aria-label="Description" name="description"></textarea>
                </div>
            </div>
            <button type="submit" class="btn btn-primary" data-toggle="tooltip" data-placement="top"
                    title="Tooltip on top">Create
            </button>
        </form>
    </div>
</@main.renderWith>