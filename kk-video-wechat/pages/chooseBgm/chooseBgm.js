const app = getApp()

Page({
    data: {
      bgmList: [],
      serverUrl: "",
      resourceUrl:"",
      videoParams: {}
    },

    onLoad: function (params) {
      
      var me = this;
      me.setData({
        videoParams: params
      });

      wx.showLoading({
        title: '请等待...',
      });
      var serverUrl = app.serverUrl;
      var resourceUrl = app.resourceUrl;
      var user = app.getGlobalUserInfo();
      wx.request({
        url: serverUrl + '/bgm/list',
        method: "POST",
        header: {
          'content-type': 'application/json', // 默认值
          'headerUserId': user.id,
          'headerUserToken': user.userToken
        },
        success: function (res) {
          wx.hideLoading();
          if (res.data.status == 200) {
            var bgmList = res.data.data;
            me.setData({
              bgmList: bgmList,
              resourceUrl: resourceUrl
            });
          } else if (res.data.status == 502) {
            wx.showToast({
              title: res.data.msg,
              duration: 2000,
              icon: "none",
              success: function () {
                wx.redirectTo({
                  url: '../userLogin/login',
                })
              }
            });
          }
        }
      })
    },

    upload: function(e) {
      var me = this;

      var bgmId = e.detail.value.bgmId;
      var desc = e.detail.value.desc;


      var duration = me.data.videoParams.duration;
      var tmpHeight = me.data.videoParams.tmpHeight;
      var tmpWidth = me.data.videoParams.tmpWidth;
      var tmpVideoUrl = me.data.videoParams.tmpVideoUrl;
      var tmpCoverUrl = me.data.videoParams.tmpCoverUrl;
      wx.showLoading({
        title: '上传中...',
      })
      var serverUrl = app.serverUrl;
      var userInfo = app.getGlobalUserInfo();

      wx.uploadFile({
        url: serverUrl + '/video/upload',
        formData: {
          userId: userInfo.id,    // fixme 原来的 app.userInfo.id
          bgmId: bgmId,
          desc: desc,
          videoSeconds: duration,
          videoHeight: tmpHeight,
          videoWidth: tmpWidth
        },
        filePath: tmpVideoUrl,
        name: 'file',
        header: {
          'content-type': 'application/json', // 默认值
          'headerUserId': userInfo.id,
          'headerUserToken': userInfo.userToken
        },
        success: function (res) {
          var data = JSON.parse(res.data);
          wx.hideLoading();
          if (data.status == 200) {
            wx.showToast({
              title: '上传成功!~~',
              icon: "success"
            });     
            // 上传成功后跳回之前的页面
            wx.navigateBack({
              delta: 1
            })

            var videoId = data.data;
            
            wx.showLoading({
              title: '上传中...',
            })
            
    


          } else if (res.data.status == 502) {
            wx.showToast({
              title: res.data.msg,
              duration: 2000,
              icon: "none"
            });
            wx.redirectTo({
              url: '../userLogin/login',
            })
          } else {
            wx.showToast({
              title: '上传失败!~~',
              icon: "success"
            });
          }

        }
      })
    }
})

