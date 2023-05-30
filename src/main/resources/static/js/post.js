let main = {
    init: function () {
        let _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save: function (){
        let data = {
            title: $('#title').val(),
            content: $('#content').val(),
            writer: $('#writer').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/post',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8,',
            data: JSON.stringify(data),
        }).done(function() {
            alert("등록");
            window.location.href = "/board";
        }).fail(function (){
            alert("실패");
        })


    }
};
main.init();