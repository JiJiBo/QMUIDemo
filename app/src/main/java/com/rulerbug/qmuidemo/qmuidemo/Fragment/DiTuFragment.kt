package com.rulerbug.qmuidemo.qmuidemo.Fragment

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.baidu.location.BDLocation
import com.baidu.location.BDLocationListener
import com.baidu.location.LocationClient
import com.baidu.location.LocationClientOption
import com.baidu.mapapi.map.MapStatusUpdateFactory
import com.baidu.mapapi.map.MapView
import com.baidu.mapapi.map.MyLocationData
import com.baidu.mapapi.model.LatLng
import com.rulerbug.qmuidemo.qmuidemo.Base.BaseFragment
import com.rulerbug.qmuidemo.qmuidemo.R


class DiTuFragment : BaseFragment() {
    var locationClient: LocationClient? = null
    override fun init() {
        locationClient = LocationClient(context!!)
        locationClient!!.registerLocationListener(MyLocationListener())
        requestDingWei()
        setMap()
    }

    private fun setMap() {
        mapView!!.map.isMyLocationEnabled = true
    }

    val REQUEST_CODE = 100
    fun requestDingWei() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // 检查是否有存储和拍照权限
            if (
                    context!!.checkSelfPermission(Manifest.permission.READ_PHONE_STATE) === PackageManager.PERMISSION_GRANTED
                    && context!!.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) === PackageManager.PERMISSION_GRANTED
                    && context!!.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) === PackageManager.PERMISSION_GRANTED
            ) {
                //有权限
                dingwei()
            } else {
                //没有权限，开始申请
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA), REQUEST_CODE)
            }
        } else {
            dingwei()
        }
    }

    private fun dingwei() {
        initLocation()
        //开始定位
        locationClient!!.start()
    }

    private fun initLocation() {

        //设置刷新和需要文字形式的地址
        //并且每5秒刷新一次
        val option = LocationClientOption()
        option.setScanSpan(5000)
        option.setIsNeedAddress(true);

        locationClient!!.locOption = option
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_ditu
    }

    var tv: TextView? = null
    var mapView: MapView? = null

    override fun initViews(rootView: View) {
        tv = rootView.findViewById(R.id.tv)
        mapView = rootView.findViewById(R.id.mv)
    }

    inner class MyLocationListener : BDLocationListener {
        override fun onReceiveLocation(location: BDLocation?) {
            //这里得到位置
            val sb: StringBuffer = StringBuffer()
            sb.append("纬度：\t" + location!!.latitude)
            sb.append("经度：\t" + location!!.longitude)
            sb.append("\n地址： \t" + location!!.country)
            sb.append("\t" + location!!.province)
            sb.append("\t" + location!!.city)
            sb.append("\t" + location!!.district)
            sb.append("\t" + location!!.street)
            sb.append("\n正在使用" + if ((location!!.locType == BDLocation.TypeNetWorkLocation)) "网络数据（不精确）" else if ((location!!.locType == BDLocation.TypeGpsLocation)) "卫星数据（精确）" else "未知数据")
            tv!!.setText(sb.toString())
            if (location!!.locType == BDLocation.TypeNetWorkLocation || location!!.locType == BDLocation.TypeGpsLocation) {
                navigateTo(location)
            }
        }

    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                dingwei()
            } else {
                Toast.makeText(context, "权限授予失败！", Toast.LENGTH_SHORT).show()
            }
        }
    }

    var isFirst: Boolean = true
    fun navigateTo(location: BDLocation) {
        if (isFirst) {
            //更新地图位置
            val ll = LatLng(location.latitude, location.longitude)
            var update = MapStatusUpdateFactory.newLatLng(ll)
            mapView!!.map.animateMapStatus(update)
            update = MapStatusUpdateFactory.zoomTo(12.5f)
            mapView!!.map.animateMapStatus(update)
            isFirst = false
        }
        //设置自己在地图上的显示
        val builder = MyLocationData.Builder()
        builder.latitude(location.latitude)
        builder.longitude(location.longitude)
        val build = builder.build()
        mapView!!.map.setMyLocationData(build)
    }

    override fun onDestroy() {
        super.onDestroy()
        locationClient!!.stop()
        mapView!!.onDestroy()
        mapView!!.map.isMyLocationEnabled = false
    }

    override fun onResume() {
        super.onResume()
        mapView!!.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView!!.onPause()
    }
}