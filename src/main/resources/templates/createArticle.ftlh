<#import "partials/main.ftlh" as main>
<@main.renderWith>

    <div>
        <h2>Create a new article</h2>

        <form action="/articles/create" method="post">
            <div class="form-group">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="basic-addon1">Title:</span>
                    </div>
                    <input type="text" class="form-control" aria-label="Title" aria-describedby="basic-addon1">
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Description:</span>
                    </div>
                    <textarea class="form-control" aria-label="Description"></textarea>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="inputGroupFile" aria-describedby="inputGroupFileAddon">
                        <label class="custom-file-label" for="inputGroupFile">Choose file</label>
                    </div>
                    <div class="input-group-append">
                        <button class="btn btn-secondary" type="button" id="inputGroupFileAddon">Upload</button>
                    </div>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Create</button>
        </form>
    </div>

</@main.renderWith>