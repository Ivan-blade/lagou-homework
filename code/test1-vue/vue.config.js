const path = require('path')
function resolve (dir) {
  return path.join(__dirname, dir)
}
module.exports = {
    pluginOptions: { // 第三方插件配置
      'style-resources-loader': {
        preProcessor: 'less',
        patterns: [path.resolve(__dirname, './src/assets/css/base.less')] // less所在文件路径
      }
    },
    devServer: {
      host: '0.0.0.0',
      port: 8080,
      proxy: {
          'api': {
              target: 'http://localhost:8082',
              changeOrigin:false,
              pathRewrite: {
                  '/api': '/'
              }
          }
      }
    }
  }