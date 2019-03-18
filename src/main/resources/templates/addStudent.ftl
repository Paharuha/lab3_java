<#import "parts/common.ftl" as c>

<@c.page>
    <form method="post" enctype="multipart/form-data">
        <div class="form-group row">
            <label for="firstName" class="col-sm-2 col-form-label">Ім'я</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Ім'я студента">
            </div>
        </div>
        <div class="form-group row">
            <label for="lastName" class="col-sm-2 col-form-label">Прізвище</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Прізвище студента">
            </div>
        </div>
        <div class="form-group row">
            <label for="studentGroup" class="col-sm-2 col-form-label">Група</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="studentGroup" name="studentGroup" placeholder="Група студента">
            </div>
        </div>
        <div class="form-group row">
            <label for="averageMark" class="col-sm-2 col-form-label">Середній бал</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="averageMark" name="averageMark" placeholder="Середній бал">
            </div>
        </div>

        <div class="form-group row">
            <div class="col-sm-2">Стипендія</div>
            <div class="col-sm-10">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="hasScholarship"
                           name="hasScholarship" checked>
                    <label class="form-check-label" for="hasScholarship">
                        стипендія
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group row" id="sc">
            <label for="scholarship" class="col-sm-2 col-form-label">Сума стипендії</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="scholarship" name="scholarship" placeholder="Сума стипендії">
            </div>
        </div>
        <div class="form-group">
            <div class="custom-file">
                <label for="customFile" class="custom-file-label">Вибрати фото</label>
                <input type="file" name="file" id="customFile" class="form-control">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-10">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-primary">Додати студента</button>
            </div>
        </div>
    </form>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script>
        $(document).ready( function () {

            $("#hasScholarship").change(function() {
                if(this.checked) {
                    $("#sc").show();
                    $("#scholarship").val("");
                } else {
                    $("#sc").hide();
                    $("#scholarship").val(0);
                }
            });

        });
    </script>
</@c.page>
