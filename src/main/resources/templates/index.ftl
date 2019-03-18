<#import "parts/common.ftl" as c>

<@c.page>
    <h2>Список студентів</h2>
    <div class="card-columns">
        <#list students as student>
            <#--<div class="card-columns">-->
                <div class="card p-4 ${student.getRandom()}" style="width: 350px">
                    <div>
                        <#if student.profilePhoto??>
                            <img src="/img/${student.profilePhoto}" class="card-img-top">
                        </#if>
                    </div>
                    <div class="card-body">
                        <h5 class="card-title"><u>${student.firstName} ${student.lastName}</u></h5>
                        <p class="card-text"><i>Група:</i> <b>${student.studentGroup}</b></p>
                        <#if student.hasScholarship>
                            <p class="card-text"><i>Стипендія:</i> <b>${student.scholarship}</b></p>
                        </#if>
                    </div>
                    <a href="/edit/${student.id}" class="btn btn-primary">Редагувати</a>
                    <a href="/remove/${student.id}" class="btn btn-danger ml-3">Видалити</a>
                </div>
            <#--</div>-->
        <#else >
            <h4>База пуста</h4>
        </#list>
    </div>
</@c.page>
