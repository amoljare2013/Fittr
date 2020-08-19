package com.amol.jare.fittrapp.model

import com.amol.jare.fittrapp.model.api.fittrResp

internal object ExpandableListData {
    val data: HashMap<String, MutableList<fittrResp>>
        get() {
            val expandableListDetail = HashMap<String, MutableList<fittrResp>>()

            val users:MutableList<fittrResp> = ArrayList<fittrResp>()
            users.add(fittrResp("null","test","","https://staticsrc.squats.in/fittr/initials/T.png"))
            users.add(fittrResp("null","test","","https://staticsrc.squats.in/fittr/initials/T.png"))
            users.add(fittrResp("test-1-1-1-1-1-1-1-1-1-1-1","test","","https://staticsrc.squats.in/fittr/initials/T.png"))

            val post:MutableList<fittrResp> = ArrayList<fittrResp>()
            post.add(fittrResp("null","Atul new","test45","https://staticsrc.squats.in/fittr/initials/A.png"))
            post.add(fittrResp("null","Rupesh morankar","testing","https://bucket-community.s3.ap-south-1.amazonaws.com/1593625819819filtered_OldManScreenshot_2020-06-10-17-10-26-482_com.squats.fittr.jpeg"))
            post.add(fittrResp("null","saurabh baviskar test","test2","https://s3-ap-south-1.amazonaws.com/bucket-community/45B6D18A-4ACC-4500-B7A1-50BA8202110E_2020-05-04_16:54:31.jpeg"))

            val recipes:MutableList<fittrResp> = ArrayList<fittrResp>()
            recipes.add(fittrResp("test","saurabh baviskar test","test","https://s3-ap-south-1.amazonaws.com/bucket-community/45B6D18A-4ACC-4500-B7A1-50BA8202110E_2020-05-04_16:54:31.jpeg"))
            recipes.add(fittrResp("test","Kapil Malviya","test","https://s3-ap-south-1.amazonaws.com/bucket-community/5338F8D2-3544-49C4-8711-4B83BAC9F3EA_2020-05-04_10:28:34.jpeg"))
            recipes.add(fittrResp("test","saurabh baviskar test","test","https://s3-ap-south-1.amazonaws.com/bucket-community/45B6D18A-4ACC-4500-B7A1-50BA8202110E_2020-05-04_16:54:31.jpeg"))

            val article:MutableList<fittrResp> = ArrayList<fittrResp>()
            article.add(fittrResp("test","Sonal Bhushanwar","test","https://dxek6y9xay9h9.cloudfront.net/1552284033422compressedcroppedIMG_20181212_183200_030.jpg"))
            article.add(fittrResp("test","Sonal Bhushanwar","test","https://dxek6y9xay9h9.cloudfront.net/1552284033422compressedcroppedIMG_20181212_183200_030.jpg"))
            article.add(fittrResp("test","Happy Singh","test","https://s3.ap-south-1.amazonaws.com/squats.storage/upload/profilepics/thumb/thumb_1486812474_IMG_0349.PNG"))

            val exercise:MutableList<fittrResp> = ArrayList<fittrResp>()
            exercise.add(fittrResp("test","test","","https://img.youtube.com/vi//0.jpg"))
            exercise.add(fittrResp("test","test url","","https://img.youtube.com/vi//0.jpg"))

            val food:MutableList<fittrResp> = ArrayList<fittrResp>()
            food.add(fittrResp("test","test12","Leafy Vegetables","https://s3.amazonaws.com/fooddata.fittr/cabbage.jpg"))
            food.add(fittrResp("test","test12","Leafy Vegetables","https://s3.amazonaws.com/fooddata.fittr/cabbage.jpg"))
            food.add(fittrResp("test","test12","Leafy Vegetables","https://s3.amazonaws.com/fooddata.fittr/cabbage.jpg"))

            expandableListDetail["Users"] = users
            expandableListDetail["Posts"]= post
            expandableListDetail["Recipes"] = recipes
            expandableListDetail["Articles"]=article
            expandableListDetail["Exercise"]=exercise
            expandableListDetail["food"]=food

            return expandableListDetail
        }
}