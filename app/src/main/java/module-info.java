module com.example.app {

	opens com.example.app to com.example.lib;

	requires com.example.lib;

	exports com.example.app;
}
