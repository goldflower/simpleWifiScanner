# simpleWifiScanner

Since startScan was deprecated in API 28, use getScanResults periodically instead.

After API 29, the following conditions should be met:

1. ACCESS_FINE_LOCATION permission.
2. ACCESS_COARSE_LOCATION permission.
3. ACCESS_WIFI_STATE permission.
4. Location services are enabled on the device. (i.e., GPS)

Not sure if we could avoid 4 :(
