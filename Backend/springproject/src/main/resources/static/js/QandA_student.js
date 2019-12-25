new Vue({
    el: "#questionBrief",
    data() {
        return {
            questions: [],
            userId: Number(getUrlParam('param')),
            currentPage: 1,
            questionInput: '',
            loading: true,
            totalPages: 0,
            questionsNum: 0,
        }
    },
    methods: {
        showAnswer: function (index) {
            $("#answer_" + index).toggle();
        },

        hideAnswer: function (index) {
            $("#answer_" + index).hide();
        },

        generateAnswerId: function (index) {
            return "answer_" + index
        },

        select: function (n) {
            if (n === this.currentPage) return
            if (typeof n === 'string') return
            this.currentPage = n
        },

        prevOrNext: function (n) {
            this.currentPage += n
            this.currentPage < 1 ?
                this.currentPage = 1 :
                this.currentPage > this.totalPages ?
                    this.currentPage = this.totalPages :
                    null
        },

        raiseQuestion: function () {
            var t = this
            t.loading = true;
            console.log(t.userId)
            if (this.userId === '') {
                // force it to jump to login page
            } else if (t.questionInput != null &&
                t.questionInput.length !== 0 &&
                t.questionInput.replace(/(^s*)|(s*$)/g, "").length !== 0 &&
                !(t.isNull(t.questionInput)) ) {
                axios
                    .post('QandA_student/askQuestion', {
                        studentId: t.userId,
                        questionAsk: t.questionInput
                    })
                    .then(response => {
                        console.log(response)

                        if (response.data.state == "success") {
                            alert("发表成功")
                            this.questions.unshift(response.data);
                            console.log(this.questions)
                        } else if (response.state == "fail") {
                            alert("发表失败")
                        } else {
                            alert("后端的锅: There must be something wrong in backend.")
                        }
                    })
                    .catch(error => {
                        console.log(error);
                        alert("未知错误， 请联系相关负责人员")
                    })
                    .finally(() => {
                        t.loading = false;
                    })
            } else {
                alert("未知错误， 请联系相关负责人员");
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

    mounted: function () {
        axios
            .post('/QandA_getInfo', {userId: 11711335})
            .then(response => {
                this.questions = response.data.questions;
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

    computed: {
        pages: function () {
            const c = this.currentPage;
            const t = this.totalPages;
            console.log(t)
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
            const c = this.currentPage;
            const n = this.questionsNum;
            console.log(n);
            var s = (c - 1) * 10;
            var e = (c - 1) * 10 + 9;
            if (e > n - 1) {
                e = n - 1;
            }
            var foo = [];
            for (var i = s; i <= e; i++) {
                foo.push(i);
            }
            console.log(foo)
            return foo
        }
    },

    watch: {
        questions: function (val, oldVal) {
            if (this.questions === null) {
                this.questionsNum = 0;
            } else {
                console.log(this.questions.length)
                this.questionsNum = this.questions.length;
            }
            console.log(this.questionsNum);
            if (this.questionsNum === 0) {
                this.totalPages = 1;
            } else {
                this.totalPages = Math.ceil(this.questionsNum / 10);
            }
            console.log(this.totalPages)
        },
        immediate: true,
        deep: true
    }

})
