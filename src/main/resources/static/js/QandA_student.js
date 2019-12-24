new Vue({
    el: "#questionBrief",
    data: {
        questions: null,
        currentPage: 1,
        userId: null,
        questionInput: null

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
            if (n === this.currentPage) return
            if (typeof n === 'string') return
            this.currentPage = n
        },

        prevOrNext: function(n) {
            this.currentPage += n
            this.currentPage < 1 ?
                this.currentPage = 1 :
                this.currentPage > Math.ceil(this.questions.length / 10) ?
                this.currentPage = Math.ceil(this.questions.length / 10) :
                null
        },

        raiseQuestion: function() {

            if (userId == null) {
                // 强制跳转至登录界面
            } else if (questionInput != null &&
                questionInput.length != 0 &&
                questionInput.replace(/(^s*)|(s*$)/g, "").length == 0 &&
                this.isNull(questionInput)) {
                axios
                    .post('/askQuestion', {
                        studentId: this.userId,
                        questionAsk: this.questionInput
                    })
                    .then(function(response) {
                        console.log(response);
                        if (response != null) {
                            if (response.data.state == "suceess") {
                                alert("发表成功")
                                this.data.questions = response.questions;
                            } else if (response.state == "fail") {
                                alert("发表失败")
                            } else {
                                alert("后端的锅: There must be something wrong in backend.")
                            }
                        }
                    })
                    .catch(function(error) {
                        console.log(error);
                        alert("未知错误， 请联系相关负责人员")
                    });
            }
        },

        isNull(str) {
            if (str == "") {
                return true;
            }
            var regu = "^[ ]+$";
            var re = new RegExp(regu);
            return re.test(str);
        }

    },
    computed: {
        totalPages: {
            get: function() {
                return Math.ceil(this.questions.length / 10)
            }
        },

        pages() {
            const c = this.currentPage
            const t = Math.ceil(this.questions.length / 10)
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
            if (e > this.questions.length - 1) {
                e = this.questions.length - 1;
            }
            var foo = [];
            for (var i = s; i <= e; i++) {
                foo.push(i);
            }

            return foo
        }
    },
    mounted() {
        axios
            .get('/QandA_getInfo',{
                userId: 11711335
            })
        then(function(response) {
                this.questions = response.data.questions
                this.userId = response.data.userId
            })
            .catch(function(error) {
                console.log(error);
            });
    }


})