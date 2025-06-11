<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/layout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:gravity="center"
    android:padding="24dp"
    tools:context=".MainActivity">

    <!-- Texto para mostrar la ubicación -->
    <TextView
        android:id="@+id/txtLocation"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Ubicación no disponible"
        android:textSize="18sp"
        android:textColor="#000000"
        android:layout_marginBottom="32dp" />

    <!-- Botón para obtener ubicación -->
    <Button
        android:id="@+id/btnLocation"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Obtener ubicación"
        android:padding="12dp" />

</LinearLayout>
