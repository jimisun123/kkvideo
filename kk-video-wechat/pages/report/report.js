const app = getApp()

Page({
    data: {
        reasonType: "请选择原因",
        reportReasonArray: app.reportReasonArray,
        publishUserId:"",
        videoId:""
    },

    onLoad:function(params) {
      var me = this;

      var videoId = params.videoId;
      var publishUserId = params.publishUserId;

      me.setData({
        publishUserId: publishUserId,
        videoId: videoId
      });
    },

    changeMe:function(e) {
      var me = this;

      var index = e.detail.value;
      var reasonType = app.reportReasonArray[index];

      me.setData({
        reasonType: reasonType
      });
    },

    submitReport:function(e) {
      var me = this;

      var reasonIndex = e.detail.value.reasonIndex;
      var reasonContent = e.detail.value.reasonContent;

      var user = app.getGlobalUserInfo();
      var currentUserId = user.id;

      if (reasonIndex == null || reasonIndex == '' || reasonIndex == undefined) {
        wx.showToast({
          title: '选择举报理由',
          icon: "none"
        })
        return;
      }

      var serverUrl = app.serverUrl;
      wx.request({
        url: serverUrl + '/user/reportUser',
        method: 'POST',
        data: {
          dealUserId: me.data.publishUserId,
          dealVideoId: me.data.videoId,
          title: app.reportReasonArray[reasonIndex],
          content:reasonContent,
          userid: currentUserId
        },
        header: {
          'content-type': 'application/json', // 默认值
          'headerUserId': user.id,
          'headerUserToken': user.userToken
        },
        success:function(res) {
          wx.showToast({
            title: res.data.msg,
            duration: 2000,
            icon: 'none',
            success: function() {
              wx.navigateBack();
            }
          })
        }

      })

    }
    
})
