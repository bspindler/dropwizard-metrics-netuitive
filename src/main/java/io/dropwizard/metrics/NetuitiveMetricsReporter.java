package io.dropwizard.metrics;

import com.codahale.metrics.Clock;
import com.codahale.metrics.Counter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.Histogram;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.ScheduledReporter;
import com.codahale.metrics.Timer;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.Locale;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Created by bspindler on 6/12/16.
 */
public class NetuitiveMetricsReporter extends ScheduledReporter  {

    private final Locale locale;
    private final Clock clock;
    private final TimeZone timeZone;

    /**
     * TODO: wire in Ananke client https://github.com/Netuitive/Ananke
     */

    private NetuitiveMetricsReporter(MetricRegistry registry,
                            String host, // hostname of netuitive-statsd server
                            int port, // port of netuitive-statsd server
                            Locale locale,
                            Clock clock,
                            TimeZone timeZone,
                            TimeUnit rateUnit,
                            TimeUnit durationUnit,
                            MetricFilter filter) {
        super(registry, "netuitive-reporter", filter, rateUnit, durationUnit);
        this.locale = locale;
        this.clock = clock;
        this.timeZone = timeZone;
    }

    /**
     * Returns a new {@link Builder} for {@link NetuitiveMetricsReporter}.
     *
     * @param registry the registry to report
     * @return a {@link Builder} instance for a {@link NetuitiveMetricsReporter}
     */
    public static Builder forRegistry(final MetricRegistry registry) {
        return new Builder(registry);
    }

    /**
     * A builder for {@link NetuitiveMetricsReporter} instaces.
     */
    @NotThreadSafe
    public static final class Builder {

        private final MetricRegistry registry;
        private TimeUnit rateUnit;
        private TimeUnit durationUnit;
        private MetricFilter filter;

        private Builder (MetricRegistry registry) {
            this.registry = registry;
            this.rateUnit = TimeUnit.SECONDS;
            this.durationUnit = TimeUnit.MILLISECONDS;
            this.filter = MetricFilter.ALL;
        }

        /**
         * Convert rates to the given time unit.
         *
         * @param _rateUnit a unit of time
         * @return {@code this}
         */
        public Builder convertRatesTo(final TimeUnit _rateUnit) {
            this.rateUnit = _rateUnit;
            return this;
        }

        /**
         * Convert durations to the given time unit.
         *
         * @param _durationUnit a unit of time
         * @return {@code this}
         */
        public Builder convertDurationsTo(final TimeUnit _durationUnit) {
            this.durationUnit = _durationUnit;
            return this;
        }

        /**
         * Only report metrics which match the given filter.
         *
         * @param _filter a {@link MetricFilter}
         * @return {@code this}
         */
        public Builder filter(final MetricFilter _filter) {
            this.filter = _filter;
            return this;
        }

        /**
         * Builds a {@link NetuitiveMetricsReporter} with the given properties, sending metrics to netuitive-statsd at the given host and port.
         *
         * @param host the hostname of the netuitive-statsd server.
         * @param port the port of the netuitive-statsd server. This is typically 8125.
         * @return a {@link NetuitiveMetricsReporter}
         */
        public NetuitiveMetricsReporter build(final String host, final int port) {
            //return build(new StatsD(host, port));
            return null;
        }

        /**
         * Builds a {@link NetuitiveMetricsReporter} with the given properties, sending metrics using the
         * given {@link Ananke} client.
         *
         * @param ananke a {@link Ananke} client
         * @return a {@link NetuitiveMetricsReporter}
         */
        public NetuitiveMetricsReporter build(final String ananke) {
            //return new NetuitiveMetricsReporter(registry, statsD, prefix, rateUnit, durationUnit, filter);
            return null;
        }
    }

    /**
     * Called periodically by the polling thread. Subclasses should report all the given metrics.
     *
     * @param gauges     all of the gauges in the registry
     * @param counters   all of the counters in the registry
     * @param histograms all of the histograms in the registry
     * @param meters     all of the meters in the registry
     * @param timers     all of the timers in the registry
     */
    @Override
    public void report(SortedMap<String, Gauge> gauges,
                       SortedMap<String, Counter> counters,
                       SortedMap<String, Histogram> histograms,
                       SortedMap<String, Meter> meters,
                       SortedMap<String, Timer> timers) {



    }
}
