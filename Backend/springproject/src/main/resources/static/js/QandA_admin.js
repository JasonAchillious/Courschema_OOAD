
new Vue({
    el: "#questionBrief",
    data: {
        adminId: Number(getUrlParam('param')),
        questions: [],
        currentPage: 1,
        answerQuestionId: -1,
        answerQuestionIndex: -1,
        answerContent: ' ',
        loading: true,
        totalPages: 0,
        questionsNum: 0,
        modalTitle: " ",
        modalBody: ' ',
        modalText: ' ',
        isDeleteQuestion: false,
        isDeleteAnswer: false,
        isAdd: false
    },

    methods: {
        showAnswer: function(index) {
            $("#answer_" + index).toggle();
        },

        hideAnswer: function(index) {
            $("#answer_" + index).hide();
        },

        generateAnswerId: function(index) {
            return "answer_" + index
        },

        select: function(n) {
            if (n === this.currentPage) return;
            if (typeof n === 'string') return;
            this.currentPage = n
        },

        prevOrNext: function(n) {
            this.currentPage += n
            this.currentPage < 1 ?
                this.currentPage = 1 :
                this.currentPage > this.totalPages ?
                    this.currentPage = this.totalPages :
                    null
        },

        isNull(str) {
            if (str == "") {
                return true;
            }
            var regu = "^[ ]+$";
            var re = new RegExp(regu);
            return re.test(str);
        },

        updateAnswer: function() {
            this.loading = true;
            var url;
            if (this.isAdd){
                url = 'QandA_admin/addAnswer'
            }else {
                url = 'QandA_admin/updateAnswer'
            }
            if (this.adminId === -1) {
                alert("非管理员请勿操作")
            } else if (this.answerContent != null &&
                this.answerContent !== 0 &&
                this.answerContent.replace(/(^s*)|(s*$)/g, "").length !== 0 &&
                !(this.isNull(this.answerContent))) {
                console.log(url)
                console.log(this.adminId)
                console.log(this.answerQuestionId)
                console.log(this.answerContent)
                axios
                    .post(url, {
                        adminId: this.adminId,
                        questionId: this.answerQuestionId,
                        answerContent: this.answerContent
                    })
                    .then(response => {
                        console.log(response);

                        if (response != null) {
                            if (response.data.state == "success") {
                                this.questions = response.data.questions;
                                alert("提交成功");
                                console.log(this.questions)
                            } else if (response.status == "fail") {
                                alert("提交失败")
                            } else {
                                alert("后端的锅: There must be something wrong in backend.")
                            }
                        }

                    })
                    .catch(function(error) {
                        console.log(error);
                        alert("未知错误， 请联系相关负责人员")
                    })
                    .finally(() => {
                        this.loading = false;
                        $('#updateModal').modal('hide')

                    })
            } else {
                alert("未知错误， 请联系相关负责人员")
            }

        },

        updateModal: function(id, index) {
            this.isAdd = false;
            this.isDeleteAnswer = false;
            this.isDeleteQuestion = false;
            this.answerQuestionId = id;
            this.answerQuestionIndex = index;
            this.modalTitle = "修改回答";
            this.modalBody = "请在下方输入您想要修改的回答";
            this.modalText = "修改内容:";
            $('#updateModal').modal('show')

        },

        addModal: function (id, index) {
            this.isAdd = true;
            this.isDeleteAnswer = false;
            this.isDeleteQuestion = false;
            this.answerQuestionId = id;
            this.answerQuestionIndex = index;
            this.modalTitle = "添加回答";
            this.modalBody= "请在下方输入您的回答";
            this.modalText = "您的回答:";
            $('#updateModal').modal('show')

        },

        deleteAnswerModal: function(id, index){
            this.answerQuestionId = id;
            this.answerQuestionIndex = index;
            this.modalBody = "您确定删除该回答吗？";
            this.isDeleteAnswer = true;
            this.isDeleteQuestion = false
            $('#updateModal').modal('show')
        },

        deleteQuestionModal: function(id, index){
            this.answerQuestionId = id;
            this.answerQuestionIndex = index;
            this.modalBody = "您确定删除该问题吗？";
            this.isDeleteQuestion = true;
            this.isDeleteAnswer = false;
            $('#updateModal').modal('show')
        },

        deleteAnswer: function () {
            this.loading = true
            axios
                .post('/QandA_admin/deleteAnswer',
                    {
                        userId: this.userId,
                        questionID: this.answerQuestionId
                    })
                .then(response => {
                    if (response.data.state === "success"){
                        console.log(response)
                        this.questions = response.data.questions
                        console.log(this.questions)
                        alert("删除回答成功")
                    }else if (response.data.state === "fail"){
                        alert("删除回答失败")
                    }
                    console.log(response)
                })
                .catch(error => {
                    console.log(error);
                    alert("未知错误， 请联系相关负责人员")
                })
                .finally(() => {
                    this.loading = false;
                    $('#updateModal').modal('hide')
                })


        },

        deleteQuestion: function (questionId, index) {
            this.loading = true;

            axios
                .post('/QandA_student/deleteQuestion',
                    {
                        userId: this.userId,
                        questionID: this.answerQuestionId
                    })
                .then(response => {
                    if (response.data.state === "success"){
                        // put questions[index] as empty
                        this.questions = response.data.questions
                    }else if (response.data.states === "fail"){
                        alert("删除失败")
                    }
                    console.log(response)
                })
                .catch(error => {
                    console.log(error);
                    alert("未知错误， 请联系相关负责人员")
                })
                .finally(() => {
                    this.loading = false;
                    $('#updateModal').modal('hide')
                })


        },

        clearIndexAndId: function () {

        }

    },

    computed: {

        pages() {
            const c = this.currentPage;
            const t = this.totalPages;
            if (t <= 10) {
                var foo = [];
                for (var i = 1; i <= t; i++) {
                    foo.push(i);
                }
                return foo;
            } else if (c <= 5) {
                return [1, 2, 3, 4, 5, 6, 7, 8, 9, '...', t]
            } else if (c >= t - 4) {
                return [1, '...', t - 8, t - 7, t - 6, t - 5, t - 4, t - 3, t - 2, t - 1, t]
            } else {
                return [1, '...', c - 3, c - 2, c - 1, c, c + 1, c + 2, c + 3, '...', t]
            }
        },

        computeIndex() {
            const c = this.currentPage
            var s = (c - 1) * 10;
            var e = (c - 1) * 10 + 9;
            if (e > this.questionsNum - 1) {
                e = this.questionsNum - 1;
            }
            var foo = [];
            for (var i = s; i <= e; i++) {
                foo.push(i);
            }

            return foo
        }
    },

    watch: {
        questions: function (newQusetions, oldQuestions) {

            if (this.questions == null) {
                this.questionsNum = 0;
            } else {
                console.log(this.questions.length)
                this.questionsNum = this.questions.length;
            }
            console.log(this.questionsNum);
            if (this.questionsNum == 0) {
                this.totalPages = 1;
            } else {
                this.totalPages = Math.ceil(this.questionsNum / 10);
            }
            console.log(this.totalPages)
        },
        immediate: true,
        deep: true
    },

    mounted: function () {
        axios
            .post('/QandA_getInfo', {userId: 11711335})
            .then(response => {
                this.questions = response.data.questions
                this.userId = response.data.userId
            })
            .catch(error => {
                console.log(error)
                alert("未知错误， 请联系相关负责人员")
            })
            .finally(() => {
                this.loading = false;
                console.log(this.loading)
            })
    },

})
