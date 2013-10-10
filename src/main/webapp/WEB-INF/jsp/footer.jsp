<%@page contentType="text/html" pageEncoding="UTF-8"%>
        </div>
        <script>
            $(function() {
                searchInput = $('#search');
                $(document).on('click', function(e) {
                    if (e.target !== searchInput.get(0)) {
                        $('.navbar-collapse.in').collapse('hide');
                    }
                });
            });
        </script>
    </body>
</html>
