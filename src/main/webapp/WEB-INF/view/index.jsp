<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <!-- include libraries(jQuery, bootstrap) -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <!-- include summernote css/js -->
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head>
<body>
    <div>
        <textarea class="summernote"></textarea>
    </div>
</body>
<script>
    /*$(".summernote").summernote({
        height:150,
        lang: "ko-KR",
        callbacks : {
            onImageUpload : function (image){
                const formData = new FormData();

                if(image.length > 0){
                    for (var i=0; i<image.length; i++){
                        console.log(image[i]);

                        formData.append("image", image[i], i);
                    }



                    $.ajax({
                        type:"POST",
                        url:"/file/image",
                        processData: false,
                        contentType: false,
                        data:formData,
                        success:function (data){
                            console.log(data)
                        },
                        error:function (err){
                            console.log(err)
                        }
                    });
                }
            }
        }
    });*/

    $(".summernote").summernote({
        height:150,
        lang: "ko-KR",
        callbacks : {
            onImageUpload : function (image, editor, welEditable){
                if(image.length > 0){
                    for (var i=0; i<image.length; i++){
                        console.log(image[i]);
                        const formData = new FormData();
                        formData.append("image", image[i]);
                        var $note = $(this);
                        $.ajax({
                            type:"POST",
                            url:"/file/image",
                            processData: false,
                            contentType: false,
                            data:formData,
                            success:function (data){
                                var image = $("<img>").attr("src", "/uploads/" + data.data.regFileName).css("max-width", "100%");
                                $note.summernote('insertNode', image[0] );
                            },
                            error:function (err){
                                console.log(err)
                            }
                        });
                    }
                }
            }
        }
    });

</script>
</html>