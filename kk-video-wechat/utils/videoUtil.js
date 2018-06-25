
function uploadVideo() {
  var me = this;

  wx.chooseVideo({
    sourceType: ['album','camera'],
    success: function (res) {

      var duration = res.duration;
      var tmpHeight = res.height;
      var tmpWidth = res.width;
      var tmpVideoUrl = res.tempFilePath;
      var tmpCoverUrl = res.thumbTempFilePath;

      if (duration > 11) {
        wx.showToast({
          title: '视频长度不能超过10秒...',
          icon: "none",
          duration: 2500
        })
      } else if (duration < 1) {
        wx.showToast({
          title: '视频长度太短，请上传超过1秒的视频...',
          icon: "none",
          duration: 2500
        })
      } else {
        // 打开选择bgm的页面
        wx.navigateTo({
          url: '../chooseBgm/chooseBgm?duration=' + duration
          + "&tmpHeight=" + tmpHeight
          + "&tmpWidth=" + tmpWidth
          + "&tmpVideoUrl=" + tmpVideoUrl
          + "&tmpCoverUrl=" + tmpCoverUrl
          ,
        })
      }

    }
  })

}

module.exports = {
  uploadVideo: uploadVideo
}
